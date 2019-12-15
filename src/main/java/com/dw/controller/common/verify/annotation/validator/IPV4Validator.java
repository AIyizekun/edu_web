package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsIPV4;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 匹配IPV4
 *
 * @author yangjunxiong
 * @date 2019/3/6 18:21
 */
public class IPV4Validator implements ConstraintValidator<IsIPV4, String> {

    private final static String REX = "(?:[0-9]{1,3}\\.){3}[0-9]{1,3}";

    private final static Pattern PATTERN = Pattern.compile(REX);


    @Override
    public void initialize(IsIPV4 isUserName) {

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
