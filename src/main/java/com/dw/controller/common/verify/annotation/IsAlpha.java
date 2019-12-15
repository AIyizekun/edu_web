package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.AlphaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配字母
 * <li>""  true</li>
 * <li>"  " true</li>
 * <li>null true</li>
 * <li>"aa" true</li>
 * <li>"bb" false</li>
 *
 * @author yangjunxiong
 * @date 2019/1/29 15:46
 */
@Documented
@Constraint(validatedBy = {AlphaValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsAlpha.AlphaList.class)
public @interface IsAlpha {

    String message() default "必须是字母";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface AlphaList {
        IsAlpha[] value();
    }

}
