package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.FixedPhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配国内电话号码：区号+座机号码+分机号码
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:32
 */
@Documented
@Constraint(validatedBy = {FixedPhoneValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsFixedPhone.FixedPhoneList.class)
public @interface IsFixedPhone {

    String message() default "必须是电话号";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface FixedPhoneList {
        IsFixedPhone[] value();
    }

}
