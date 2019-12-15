package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsChinaPostcode;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 邮政编码验证
 * <li>[1-9]\\d{5}</li>
 * <li>[1-9]\d{5}(?!\d)</li>
 *
 * @author yangjunxiong
 * @date 2019/1/31 15:54
 */
public class ChinaPostcodeValidator implements ConstraintValidator<IsChinaPostcode, String> {

    private final static Pattern PATTERN = Pattern.compile("[1-9]\\d{5}(?!\\d)");

    @Override
    public void initialize(IsChinaPostcode isChinaPostcode) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return true;
        } else if (PATTERN.matcher(s).find()) {
            return true;
        }
        return false;
    }

}
