package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsMobilePhone;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 匹配移动电话
 *
 * @author yangjunxiong
 * @date 2019/3/6 18:05
 */
public class MobilePhoneValidator implements ConstraintValidator<IsMobilePhone, String> {

    /*
     * 电话格式验证
     **/
    //private static final String PHONE_CALL_PATTERN = "^(\\(\\d{3,4}\\)|\\d{3,4}-)?\\d{7,8}(-\\d{1,4})?$";

    /*
     * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700
     **/
    //private static final String CHINA_TELECOM_PATTERN = "(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)";

    /*
     * 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,176,1709
     **/
    //private static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)";

    private static final String CHINA_MOBILE_PATTERN = "^1([34578])\\d{9}$";

    //private static final String CHINA_MOBILE_PATTERN2 = "(\\+\\d+)?1[3458]\\d{9}$";
    //
    //private static final String CHINA_MOBILE_PATTERN3 = "(1[34578][0-9]{9}|0[0-9]{2}-[0-9]{8}|0[0-9]{3}-[0-9]{7})";

    private final static Pattern PATTERN = Pattern.compile(CHINA_MOBILE_PATTERN);

    @Override
    public void initialize(IsMobilePhone isUserName) {

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
