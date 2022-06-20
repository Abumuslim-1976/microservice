//package uz.uzcard.services.student.executor;
//
//import lombok.RequiredArgsConstructor;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import uz.uzcard.service.dbservice.dto.ApiResponse;
//import uz.uzcard.service.dbservice.entity.User;
//import uz.uzcard.service.dbservice.enums.SystemRoleName;
//import uz.uzcard.services.student.annotation.CheckAuth;
//import uz.uzcard.services.student.exception.RestException;
//import uz.uzcard.services.student.feign.AuthFeign;
//import uz.uzcard.services.student.utils.CommonUtils;
//import uz.uzcard.services.student.utils.RestConstants;
//
//import javax.servlet.http.HttpServletRequest;
//
//
//@Order(value = 1)
//@Aspect
//@Component
//public class CheckAuthExecutor {
//
//    private final AuthFeign authFeign;
//
//    public CheckAuthExecutor(AuthFeign authFeign) {
//        this.authFeign = authFeign;
//    }
//
//    @Before(value = "@annotation(checkAuth)")
//    public void checkAuthExecutor(CheckAuth checkAuth) {
//        check(checkAuth);
//    }
//
//    public void check(CheckAuth checkAuth) {
//        String token = CommonUtils.getTokenFromRequest();
//        if (token == null) {
//            throw new RestException(HttpStatus.UNAUTHORIZED, "FORBIDDEN");
//        }
//        User user;
//        if (checkAuth.permission().equals(SystemRoleName.CHECK)) {
//            ApiResponse<User> apiResult = authFeign.checkUser(token);
//            user = apiResult.getData();
//        } else {
//            ApiResponse<User> apiResult = authFeign.checkPermission(token, checkAuth.permission());
//            user = apiResult.getData();
//            if (user == null)
//                throw new RestException(HttpStatus.FORBIDDEN, "FORBIDDEN");
//        }
//        HttpServletRequest httpServletRequest = CommonUtils.currentRequest();
//        httpServletRequest.setAttribute(RestConstants.REQUEST_ATTRIBUTE_CURRENT_USER, user);
//    }
//
//}
