package com.dw.controller.common.verify;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 实体验证器
 *
 * @author yangjunxiong
 * @date 2016年3月29日
 */
class ValidatorUtils {
    private final static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 验证实体中的某个字段是否满足约束条件
     *
     * @param entity        被验证的实体
     * @param propertyNames 被验证的实体中的某个字段
     * @return 成功返回null，否则返回错误信息
     */
    public static <T> String validate(T entity, String... propertyNames) {
        Set<ConstraintViolation<T>> validateSet = validator.validate(entity, Default.class);

        if (CollectionUtils.isNotEmpty(validateSet)) {
            for (ConstraintViolation<T> cv : validateSet) {
                if (ArrayUtils.isEmpty(propertyNames)) {
                    return StringUtils.join(cv.getPropertyPath(),":",cv.getMessage());
                } else if (ArrayUtils.contains(propertyNames, cv.getPropertyPath().toString())) {
                    return StringUtils.join(cv.getPropertyPath(),":",cv.getMessage());
                }
            }
        }
        return null;
    }

    /**
     * 验证实体是否满足约束条件,失败返回错误消息，否则返回空
     *
     * @param entity       被验证的实体
     * @param skipNull     总的设置是否验证为空字段,即忽略个别字段有@notNull的约束。默认false,将验证为null的字段
     * @param exceptFields 排除不验证的字段,默认验证所有的字段
     * @return 成功返回null，否则返回错误信息
     */
    public static <T> String validate(T entity, boolean skipNull, String... exceptFields) {
        Set<ConstraintViolation<T>> validateSet = validator.validate(entity, Default.class);

        if (CollectionUtils.isNotEmpty(validateSet)) {
            for (ConstraintViolation<T> cv : validateSet) {
                //排除为空的字段
                if (skipNull && cv.getInvalidValue() == null) {
                    continue;
                }
                //排除指定排除的字段
                List<String> propertyPathList = new ArrayList<>();
                Path path = cv.getPropertyPath();
                for (Path.Node node : path) {
                    if (StringUtils.isBlank(node.getName())) {
                        continue;
                    }
                    propertyPathList.add(node.getName());
                }
                String propertyPath = StringUtils.join(propertyPathList, ".");
                if (ArrayUtils.contains(exceptFields, propertyPath)) {
                    continue;
                }
                return StringUtils.join(cv.getPropertyPath(),":",cv.getMessage());
            }
        }
        return null;
    }


    /**
     * 根据指定的验证器,验证实体是否满足约束条件
     *
     * @param entity    被验证的实体
     * @param validator 自定义验证器
     * @return 成功返回null，否则返回错误信息
     */
    public static <T> String validate(T entity, Validator validator) {
        Set<ConstraintViolation<T>> validateSet = validator.validate(entity, Default.class);
        if (CollectionUtils.isNotEmpty(validateSet)) {
            ConstraintViolation<T> cv = validateSet.iterator().next();
            return StringUtils.join(cv.getPropertyPath(),":",cv.getMessage());
        }
        return null;
    }


}
