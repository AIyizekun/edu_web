package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.ChinaIDCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配身份证
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:29
 */
@Documented
@Constraint(validatedBy = {ChinaIDCardValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsChinaIDCard.ChinaIDCardList.class)
public @interface IsChinaIDCard {

    String message() default "必须是身份证号";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface ChinaIDCardList {
        IsChinaIDCard[] value();
    }

}
