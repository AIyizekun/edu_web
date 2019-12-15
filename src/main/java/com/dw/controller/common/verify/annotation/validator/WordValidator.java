package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsWord;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 单词字符[\w]。等价于'[A-Za-z0-9_]'
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:16
 */
public class WordValidator implements ConstraintValidator<IsWord, String> {

    private final static Pattern PATTERN = Pattern.compile("^\\w+$");

    @Override
    public void initialize(IsWord isWord) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return true;
        }

        if (PATTERN.matcher(s).find()) {
            return true;
        }

        return false;
    }

}
