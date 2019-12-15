package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.ChinaPostcodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 匹配邮政编码
 *
 * @author yangjunxiong
 * @date 2019/1/31 15:53
 */
@Documented
@Constraint(validatedBy = {ChinaPostcodeValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsChinaPostcode.PostcodeList.class)
public @interface IsChinaPostcode {

    String message() default "必须是邮政编码";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface PostcodeList {
        IsChinaPostcode[] value();
    }

}
