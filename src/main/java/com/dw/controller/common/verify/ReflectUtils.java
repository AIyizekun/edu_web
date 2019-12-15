package com.dw.controller.common.verify;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 反射工具
 *
 * @Author yangjunxiong
 * @Date 2018/3/30
 */
public final class ReflectUtils {

    private ReflectUtils() {
    }

    public static Object getFieldValue(Object obj, String fieldName) {
        if (obj == null) {
            return null;
        }

        Field targetField = getTargetField(obj.getClass(), fieldName);
        if (targetField == null) {
            return null;
        }

        try {
            return FieldUtils.readField(targetField, obj, true);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public static Field getTargetField(Class<?> targetClass, String fieldName) {
        Field field;

        try {
            if (targetClass == null) {
                return null;
            }

            if (Object.class.equals(targetClass)) {
                return null;
            }

            field = FieldUtils.getDeclaredField(targetClass, fieldName, true);
            if (field == null) {
                field = getTargetField(targetClass.getSuperclass(), fieldName);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return field;
    }

    public static void setFieldValue(Object obj, String fieldName, Object value) {
        if (null == obj) {
            return;
        }
        Field targetField = getTargetField(obj.getClass(), fieldName);
        if (targetField == null) {
            return;
        }

        try {
            FieldUtils.writeField(targetField, obj, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 返回类的字段
     *
     * @param clazz
     * @return
     */
    public static List<String> getFields(Class clazz) {
        PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(clazz);
        return Arrays.stream(propertyDescriptors)
                .map(PropertyDescriptor::getName)
                .filter((s) -> !Objects.equals("class", s))
                .collect(Collectors.toList());
    }


    /**
     * 是否是基本类型 <br>
     * 字符类型，数据类型，布尔类型
     *
     * @return
     */
    public static boolean isBaseType(Object obj) {
        if (obj == null) {
            return true;
        }
        if (Integer.class.isInstance(obj)) {
            return true;
        } else if (BigInteger.class.isInstance(obj)) {
            return true;
        } else if (BigDecimal.class.isInstance(obj)) {
            return true;
        } else if (String.class.isInstance(obj)) {
            return true;
        } else if (Float.class.isInstance(obj)) {
            return true;
        } else if (Double.class.isInstance(obj)) {
            return true;
        } else if (Short.class.isInstance(obj)) {
            return true;
        } else if (Long.class.isInstance(obj)) {
            return true;
        } else if (Character.class.isInstance(obj)) {
            return true;
        } else if (Boolean.class.isInstance(obj)) {
            return true;
        } else if (Byte.class.isInstance(obj)) {
            return true;
        }
        return false;
    }

    /**
     * 是否是基本类型 <br>
     * 字符类型，数据类型，布尔类型
     *
     * @return
     */
    public static boolean isBaseType(Class clazz) {
        if (clazz == null) {
            return true;
        }
        if (Integer.class.equals(clazz)) {
            return true;
        } else if (BigInteger.class.equals(clazz)) {
            return true;
        } else if (BigDecimal.class.equals(clazz)) {
            return true;
        } else if (String.class.equals(clazz)) {
            return true;
        } else if (Float.class.equals(clazz)) {
            return true;
        } else if (Double.class.equals(clazz)) {
            return true;
        } else if (Short.class.equals(clazz)) {
            return true;
        } else if (Long.class.equals(clazz)) {
            return true;
        } else if (Character.class.equals(clazz)) {
            return true;
        } else if (Boolean.class.equals(clazz)) {
            return true;
        } else if (Byte.class.equals(clazz)) {
            return true;
        }
        return false;
    }

}
