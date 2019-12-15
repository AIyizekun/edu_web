package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsURL;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * url 匹配
 *
 * @author yangjunxiong
 * @date 2019/3/6 18:23
 */
public class URLValidator implements ConstraintValidator<IsURL, String> {

    private final static String REX = "[a-zA-z]+://[^\\s]*";

    //private final static String REX1 = "\\b((https?|ftp|file)://|(www|ftp)\\.)[-A-Z0-9+&@#/%?=~_|$!:,.;]*[A-Z0-9+&@#/%=~_|]\\b\n";

    private final static Pattern PATTERN = Pattern.compile(REX);

    @Override
    public void initialize(IsURL isUserName) {

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
