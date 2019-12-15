package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsChinaIDCard;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 匹配身份证：\d{15}|\d{18}　 评注：中国的身份证为15位或18位
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:42
 */
public class ChinaIDCardValidator implements ConstraintValidator<IsChinaIDCard, String> {
    private final static String REX1 = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
    //private final static String REX2 = "\\d{15}|\\d{18}";

    private final static Pattern PATTERN = Pattern.compile(REX1);

    @Override
    public void initialize(IsChinaIDCard isChinaPostcode) {

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
