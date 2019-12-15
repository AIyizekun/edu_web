package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsIPAddress;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 匹配ip地址：\d+\.\d+\.\d+\.\d+ 　评注：提取ip地址时有用
 *
 * @author yangjunxiong
 * @date 2019/3/6 17:40
 */
public class IPAddressValidator implements ConstraintValidator<IsIPAddress, String> {

    private final static Pattern PATTERN = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");

    @Override
    public void initialize(IsIPAddress isChinaPostcode) {

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
