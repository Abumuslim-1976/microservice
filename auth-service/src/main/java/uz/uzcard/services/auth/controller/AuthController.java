package uz.uzcard.services.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import uz.uzcard.service.dbservice.dto.ApiResponse;
import uz.uzcard.service.dbservice.dto.LoginDto;
import uz.uzcard.service.dbservice.dto.RegisterDto;
import uz.uzcard.service.dbservice.entity.User;
import uz.uzcard.services.auth.config.JwtProvider;
import uz.uzcard.services.auth.service.AuthService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open-auth/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public HttpEntity<?> registerUser(@Valid @RequestBody RegisterDto registerDto) {
        ApiResponse<String> apiResponse = authService.registerUser(registerDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }


    @PostMapping("/login")
    public HttpEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
        ApiResponse<String> apiResponse = authService.loginToSystem(loginDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse.getData());
    }

    @GetMapping("/check-user")
    public HttpEntity<?> checkUser() {
        ApiResponse<User> checkUser = authService.checkUser();
        return ResponseEntity.status(checkUser.isSuccess() ? 200 : 409).body(checkUser.getData());
    }

}
