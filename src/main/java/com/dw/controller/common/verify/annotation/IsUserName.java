package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.UserNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配标准用户名 【必须是字母开头，允许字母数字下划线】
 *
 * @author yangjunxiong
 * @date 2019/1/31 15:45
 */
@Documented
@Constraint(validatedBy = {UserNameValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsUserName.UserNameList.class)
public @interface IsUserName {

    String message() default "必须是字母开头,字母数字下划线组成";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface UserNameList {
        IsUserName[] value();
    }


}
