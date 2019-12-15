package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsNumeric;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 全数字
 *
 * @author yangjunxiong
 * @date 2019/1/30 17:24
 */
public class NumericValidator implements ConstraintValidator<IsNumeric, String> {
    @Override
    public void initialize(IsNumeric isNumeric) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return true;
        } else if (StringUtils.isNumeric(s)) {
            return true;
        }
        return false;
    }

}
