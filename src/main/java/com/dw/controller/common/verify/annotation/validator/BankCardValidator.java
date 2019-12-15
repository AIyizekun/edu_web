package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsBankCard;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 匹配银行卡
 * @author yangjunxiong
 * @date 2019/3/6 18:22
 */
public class BankCardValidator implements ConstraintValidator<IsBankCard, String> {

    private final static String REX = "\\d{16,19}";

    private final static Pattern PATTERN = Pattern.compile(REX);


    @Override
    public void initialize(IsBankCard isUserName) {

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
