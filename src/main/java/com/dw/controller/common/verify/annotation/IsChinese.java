package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.ChineseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配中文
 *
 * @author yangjunxiong
 * @date 2019/1/29 16:04
 */
@Documented
@Constraint(validatedBy = {ChineseValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsChinese.ChineseList.class)
public @interface IsChinese {

    String message() default "必须是中文";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface ChineseList {
        IsChinese[] value();
    }

}
