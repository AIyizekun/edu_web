package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.IPV4Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配IPV4
 *
 * @author yangjunxiong
 * @date 2019/3/6 18:13
 */
@Documented
@Constraint(validatedBy = {IPV4Validator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsIPV4.IPV4List.class)
public @interface IsIPV4 {

    String message() default "必须是IPV4";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface IPV4List {
        IsIPV4[] value();
    }


}
