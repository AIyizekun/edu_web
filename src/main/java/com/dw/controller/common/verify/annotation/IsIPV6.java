package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.IPV6Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配IPV6
 *
 * @author yangjunxiong
 * @date 2019/3/6 18:13
 */
@Documented
@Constraint(validatedBy = {IPV6Validator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsIPV6.IPV6List.class)
public @interface IsIPV6 {

    String message() default "必须是IPV6";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface IPV6List {
        IsIPV6[] value();
    }


}
