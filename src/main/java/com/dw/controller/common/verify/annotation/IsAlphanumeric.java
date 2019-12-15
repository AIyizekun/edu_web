package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.AlphanumericValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配字母或数字
 *
 * @author yangjunxiong
 * @date 2019/1/29 15:47
 */
@Documented
@Constraint(validatedBy = {AlphanumericValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsAlphanumeric.AlphanumericList.class)
public @interface IsAlphanumeric {

    String message() default "必须是字母或数字";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface AlphanumericList {
        IsAlphanumeric[] value();
    }

}
