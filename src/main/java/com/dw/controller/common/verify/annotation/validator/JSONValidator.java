package com.dw.controller.common.verify.annotation.validator;

import com.alibaba.fastjson.JSON;
import com.dw.controller.common.verify.annotation.IsJSON;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * json 内容判断，根据fastJSON 来解析字符。以此来判断是否是一个有效的json字符串
 *
 * @author yangjunxiong
 * @date 2019/3/11 11:55
 */
public class JSONValidator implements ConstraintValidator<IsJSON, String> {

    @Override
    public void initialize(IsJSON isJSON) {

    }

    @Override
    public boolean isValid(String val, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(val)) {
            return true;
        }

        try {
            JSON.parseObject(val);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
