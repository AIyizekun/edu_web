package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsAlphanumeric;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 字母或数字 验证
 *
 * @author yangjunxiong
 * @date 2019/1/30 17:23
 */
public class AlphanumericValidator implements ConstraintValidator<IsAlphanumeric, String> {
    @Override
    public void initialize(IsAlphanumeric isAlphanumeric) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return true;
        } else if (StringUtils.isAlphanumeric(s)) {
            return true;
        }
        return false;
    }
}
