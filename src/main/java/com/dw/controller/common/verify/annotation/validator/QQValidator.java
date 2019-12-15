package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsQQ;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 腾讯QQ号：：[1-9][0-9]{4,}　 评注：腾讯QQ号从10000开始
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:38
 */
public class QQValidator implements ConstraintValidator<IsQQ, String> {

    private final static Pattern PATTERN = Pattern.compile("：[1-9][0-9]{4,}");

    @Override
    public void initialize(IsQQ isChinaPostcode) {

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
