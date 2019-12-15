package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsUserName;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 用户名验证逻辑 【必须是字母开头，允许字母数字下划线】
 *
 * @author yangjunxiong
 * @date 2019/1/31 15:49
 */
public class UserNameValidator implements ConstraintValidator<IsUserName, String> {

    private final static Pattern PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]*$");

    @Override
    public void initialize(IsUserName isUserName) {

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
