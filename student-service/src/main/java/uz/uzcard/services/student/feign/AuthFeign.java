package uz.uzcard.services.student.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import uz.uzcard.service.dbservice.dto.ApiResponse;
import uz.uzcard.service.dbservice.entity.User;
import uz.uzcard.service.dbservice.enums.PermissionEnum;
import uz.uzcard.services.student.config.FeignConfig;
import uz.uzcard.services.student.utils.RestConstants;

@FeignClient(name = RestConstants.AUTH_SERVICE, configuration = FeignConfig.class)
public interface AuthFeign {

    @GetMapping("/auth/check-user")
    ApiResponse<User> checkUser(@RequestHeader("Authorization") String token);

    @PostMapping("/auth/check-permission")
    ApiResponse<User> checkPermission(@RequestHeader("Authorization") String token,
                                    @RequestBody PermissionEnum permissionEnum);


}
