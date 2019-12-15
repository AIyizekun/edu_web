package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsFixedPhone;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 匹配国内电话号码：区号+座机号码+分机号码
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:37
 */
public class FixedPhoneValidator implements ConstraintValidator<IsFixedPhone, String> {

    private final static Pattern PATTERN = Pattern.compile("\\d{3}-\\d{8}|\\d{4}-\\d{7}");

    //private final static Pattern PATTERN2 = Pattern.compile("^(\\(\\d{3,4}\\)|\\d{3,4}-)?\\d{7,8}(-\\d{1,4})?$");

    //private final static Pattern PATTERN3 = Pattern.compile("(?:(\\\\(\\\\+?86\\\\))(0[0-9]{2,3}\\\\-?)?([2-9][0-9]{6,7})+(\\\\-[0-9]{1,4})?)|\" +\"(?:(86-?)?(0[0-9]{2,3}\\\\-?)?([2-9][0-9]{6,7})+(\\\\-[0-9]{1,4})?)");


    @Override
    public void initialize(IsFixedPhone isChinaPostcode) {

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
