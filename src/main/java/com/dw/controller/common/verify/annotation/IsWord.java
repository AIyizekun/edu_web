package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.WordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配单词字符:字母、数字、下划线
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:13
 */
@Documented
@Constraint(validatedBy = {WordValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsWord.WordList.class)
public @interface IsWord {

    String message() default "必须是字母、数字、下划线";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface WordList {
        IsWord[] value();
    }

}
