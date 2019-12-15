package com.dw.controller.common.verify.annotation;


import com.dw.controller.common.verify.annotation.validator.MobilePhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 匹配 手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
 * <p>
 * 移动、联通、电信运营商的号码段
 * <p><b>移动的号段</b>：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
 * 、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
 * <p><b>联通的号段</b>：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
 * <p><b>电信的号段</b>：133、153、180（未启用）、189</p>
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:56
 */
@Documented
@Constraint(validatedBy = {MobilePhoneValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(IsMobilePhone.MobilePhoneList.class)
public @interface IsMobilePhone {

    String message() default "必须是手机号";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface MobilePhoneList {
        IsMobilePhone[] value();
    }


}
