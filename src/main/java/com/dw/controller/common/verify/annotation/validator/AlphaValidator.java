package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsAlpha;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 全字母验证 <br>
 * <li>""  true</li>
 * <li>"  " true</li>
 * <li>null true</li>
 * <li>"aa" true</li>
 * <li>"bb" false</li>
 *
 * @author yangjunxiong
 * @date 2019/1/30 17:17
 */
public class AlphaValidator implements ConstraintValidator<IsAlpha, String> {

    @Override
    public void initialize(IsAlpha isAlpha) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return true;
        } else if (StringUtils.isAlpha(s)) {
            return true;
        }
        return false;
    }

}
