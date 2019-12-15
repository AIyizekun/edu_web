package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.QQValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配腾讯QQ号：[1-9][0-9]{4,}　 评注：腾讯QQ号从10000开始
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:33
 */
@Documented
@Constraint(validatedBy = {QQValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsQQ.QQList.class)
public @interface IsQQ {

    String message() default "必须是QQ号";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface QQList {
        IsQQ[] value();
    }

}
