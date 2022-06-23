package uz.uzcard.services.student.annotation;


import uz.uzcard.service.dbservice.enums.PermissionEnum;

import java.lang.annotation.*;


@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface CheckAuth {
    PermissionEnum permission() default PermissionEnum.CHECK;
}
