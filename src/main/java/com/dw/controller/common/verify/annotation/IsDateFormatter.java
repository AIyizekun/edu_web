package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.DateFormatterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配日期格式
 *
 * @author yangjunxiong
 * @date 2019/3/6 19:31
 */
@Documented
@Constraint(validatedBy = {DateFormatterValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsDateFormatter.DateFormatterList.class)
public @interface IsDateFormatter {

    String message() default "日期格式不正确";

    /**
     * 有效的日期格式
     */
    String[] format() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface DateFormatterList {
        IsDateFormatter[] value();
    }

}
