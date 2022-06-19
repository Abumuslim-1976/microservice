package uz.uzcard.services.student.annotation;


import uz.uzcard.service.dbservice.enums.SystemRoleName;

import java.lang.annotation.*;


@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface CheckAuth {
    SystemRoleName permission() default SystemRoleName.CHECK;
}
