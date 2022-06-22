/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 5/21/2021
Time: 3:57 PM
 To change this template use File | Settings | File Templates.
*/
package uz.uzcard.services.group.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;
import uz.uzcard.service.dbservice.entity.User;
import uz.uzcard.services.group.exception.RestException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class CommonUtils {
    @Value("${kelishilganSana}")
    public static String kelishilganSana;

    //bu method hozir tizimdagi requestni headerini olish uchun
    public static HttpServletRequest currentRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Optional.ofNullable(servletRequestAttributes).map(ServletRequestAttributes::getRequest).orElse(null);
    }

    public static User getUserFromRequest() {
        try {
            HttpServletRequest httpServletRequest = currentRequest();
            return (User) httpServletRequest.getAttribute(RestConstants.REQUEST_ATTRIBUTE_CURRENT_USER);
        } catch (Exception e) {
            throw new RestException(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED");
        }
    }

    //bu method request headeridan tokenni olib beradi
    public static String getTokenFromRequest() {
        try {
            return currentRequest().getHeader("Authorization");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

//    public static String buildPhotoUrl(UUID id) {
//        return RestConstants.DOMAIN +  RestConstants.ATTACHMENT_CONTROLLER + "/download/" + id;
//    }

//    @SneakyThrows
//    public  static Timestamp buildTimeStampInTime(Timestamp timestamp){
//        Time time = new Time(timestamp.getTime());
//        Timestamp timestampNew = new Timestamp(new SimpleDateFormat("dd/MM/yyy hh:mm:ss").parse(kelishilganSana + " " + time).getTime());
//        return timestampNew;
//    }
}
