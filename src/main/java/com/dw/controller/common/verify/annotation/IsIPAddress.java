package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.IPAddressValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配ip地址：\d+\.\d+\.\d+\.\d+ 　
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:31
 */
@Documented
@Constraint(validatedBy = {IPAddressValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsIPAddress.IPAddressList.class)
public @interface IsIPAddress {

    String message() default "必须是IP地址";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface IPAddressList {
        IsIPAddress[] value();
    }

}
