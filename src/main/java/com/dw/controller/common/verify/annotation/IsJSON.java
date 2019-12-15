package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.JSONValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 是一个json 字符串
 *
 * @author yangjunxiong
 * @date 2019/3/11 11:54
 */
@Documented
@Constraint(validatedBy = {JSONValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsJSON.JSONList.class)
public @interface IsJSON {

    String message() default "必须JSON字符串";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface JSONList {
        IsJSON[] value();
    }


}
