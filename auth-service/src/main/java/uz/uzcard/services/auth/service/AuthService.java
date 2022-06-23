package uz.uzcard.services.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.uzcard.service.dbservice.dto.ApiResponse;
import uz.uzcard.service.dbservice.dto.LoginDto;
import uz.uzcard.service.dbservice.dto.RegisterDto;
import uz.uzcard.service.dbservice.entity.User;
import uz.uzcard.service.dbservice.enums.SystemRoleName;
import uz.uzcard.service.dbservice.repository.UserRepository;
import uz.uzcard.services.auth.config.JwtProvider;
import uz.uzcard.services.auth.exception.RestException;

import java.util.UUID;


@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public ApiResponse<String> registerUser(RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername()))
            return new ApiResponse<>("Bunday user mavjud", false);
        User user = new User(
                registerDto.getFullName(),
                registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()),
                SystemRoleName.SYSTEM_USER
        );
        User saveUser = userRepository.save(user);
        String token = jwtProvider.generateToken(saveUser.getUsername());
        return new ApiResponse<>("User saqlandi", token, true);
    }

    public ApiResponse<String> loginToSystem(LoginDto loginDto) {
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsername(),
                    loginDto.getPassword()
            ));
            User user = (User) authenticate.getPrincipal();
            String token = jwtProvider.generateToken(user.getUsername());
            return new ApiResponse<>("Muvoffaqiyatli tizimga kirildi", token, true);
        } catch (Exception e) {
            return new ApiResponse<>("Parol yoki login xato", false);
        }
    }


    public ApiResponse<User> checkUser() {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return new ApiResponse<>(user, true);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RestException(HttpStatus.UNAUTHORIZED, "Autorizatsiyadan o'tmagan");
        }
    }

}
