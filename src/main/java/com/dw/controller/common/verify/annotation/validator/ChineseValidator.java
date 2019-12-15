package com.dw.controller.common.verify.annotation.validator;


import com.dw.controller.common.verify.annotation.IsChinese;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 中文验证逻辑
 *
 * @author yangjunxiong
 * @date 2019/1/30 17:25
 */
public class ChineseValidator implements ConstraintValidator<IsChinese, String> {

    private final static Pattern PATTERN = Pattern.compile("^[\\u4e00-\\u9fa5]*$");

    @Override
    public void initialize(IsChinese isChinese) {

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
