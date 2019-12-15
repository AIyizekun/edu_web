package com.dw.controller.common.verify.annotation.validator;

import com.dw.controller.common.verify.annotation.IsDateFormatter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

/**
 * 日期格式匹配
 *
 * @author yangjunxiong
 * @date 2019/3/6 19:34
 */
public class DateFormatterValidator implements ConstraintValidator<IsDateFormatter, String> {

    private String[] formats;

    @Override
    public void initialize(IsDateFormatter constraintAnnotation) {
        formats = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            return true;
        }

        if (formats == null || formats.length == 0) {
            return true;
        }

        for (String dateFormat : formats) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
                formatter.setLenient(false);
                formatter.parse(value);
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }
}
