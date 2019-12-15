package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.BankCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配银行卡
 *
 * @author yangjunxiong
 * @date 2019/3/6 18:12
 */
@Documented
@Constraint(validatedBy = {BankCardValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsBankCard.BankCardList.class)
public @interface IsBankCard {

    String message() default "必须是银行卡号";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface BankCardList {
        IsBankCard[] value();
    }

}
