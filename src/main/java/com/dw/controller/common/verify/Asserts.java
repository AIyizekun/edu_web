package com.dw.controller.common.verify;

import com.dw.exception.AssertsException;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 系统断言，工具类
 *
 * @Author yangjunxiong
 * @Date 2018/3/29
 */
public abstract class Asserts {
    private Asserts() {
    }

    private static String getDefaultMessage() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StackTraceElement element = stackTrace[3];
            return String.format("%s -> %s{%d}", element.getClassName(), element.getMethodName(), element.getLineNumber());
        } catch (Exception e) {
            return null;
        }
    }

    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new AssertsException(message);
        }
    }

    public static void state(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new AssertsException(nullSafeGet(messageSupplier));
        }
    }

    public static void state(boolean expression) {
        state(expression, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "[Assertion failed] - this state invariant must be true"));
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new AssertsException(message);
        }
    }

    public static void isFalse(boolean expression) {
        if (expression) {
            throw new AssertsException(org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                    "[Assertion failed] - this expression invariant must be false"));
        }
    }

    public static void isFalse(boolean expression, String message) {
        if (expression) {
            throw new AssertsException(message);
        }
    }

    public static void isTrue(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new AssertsException(nullSafeGet(messageSupplier));
        }
    }

    public static void isTrue(boolean expression) {
        isTrue(expression, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "[Assertion failed] - this expression must be true"));
    }

    public static void isNull(@Nullable Object object, String message) {
        if (object != null) {
            throw new AssertsException(message);
        }
    }

    public static void isNull(@Nullable Object object, Supplier<String> messageSupplier) {
        if (object != null) {
            throw new AssertsException(nullSafeGet(messageSupplier));
        }
    }


    public static void isNull(@Nullable Object object) {
        isNull(object, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "[Assertion failed] - the object argument must be null"));
    }

    public static void notNull(@Nullable Object object, String message) {
        if (object == null) {
            throw new AssertsException(message);
        }
    }

    public static void allNotNull(Object... object) {
        boolean flag = org.apache.commons.lang3.ObjectUtils.allNotNull(object);
        if (flag) {
            return;
        }
        throw new AssertsException(getDefaultMessage());
    }

    public static void anyNotNull(Object... object) {
        boolean flag = org.apache.commons.lang3.ObjectUtils.anyNotNull(object);
        if (flag) {
            return;
        }
        throw new AssertsException(getDefaultMessage());
    }

    public static void notNull(@Nullable Object object, Supplier<String> messageSupplier) {
        if (object == null) {
            throw new AssertsException(nullSafeGet(messageSupplier));
        }
    }

    public static void notNull(@Nullable Object object) {
        notNull(object, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "[Assertion failed] - this argument is required; it must not be null"));
    }

    public static void hasLength(@Nullable String text, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new AssertsException(message);
        }
    }

    public static void hasLength(@Nullable String text, Supplier<String> messageSupplier) {
        if (!StringUtils.hasLength(text)) {
            throw new AssertsException(nullSafeGet(messageSupplier));
        }
    }

    public static void hasLength(@Nullable String text) {
        hasLength(text, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "[Assertion failed] - this String argument must have length; it must not be null or empty"));
    }

    public static void hasText(@Nullable String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new AssertsException(message);
        }
    }

    public static void hasText(@Nullable String text, Supplier<String> messageSupplier) {
        if (!StringUtils.hasText(text)) {
            throw new AssertsException(nullSafeGet(messageSupplier));
        }
    }

    public static void hasText(@Nullable String text) {
        hasText(text, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank"));
    }

    public static void doesNotContain(@Nullable String textToSearch, String substring, String message) {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) && textToSearch.contains(substring)) {
            throw new AssertsException(message);
        }
    }

    public static void doesNotContain(@Nullable String textToSearch, String substring, Supplier<String> messageSupplier) {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) && textToSearch.contains(substring)) {
            throw new AssertsException(nullSafeGet(messageSupplier));
        }
    }

    public static void doesNotContain(@Nullable String textToSearch, String substring) {
        doesNotContain(textToSearch, substring, () -> {
            return org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(), "[Assertion failed] - this String argument must not contain the substring [" + substring + "]");
        });
    }

    public static void notEmpty(@Nullable Object[] array, String message) {
        if (ObjectUtils.isEmpty(array)) {
            throw new AssertsException(message);
        }
    }

    public static void notEmpty(@Nullable Object[] array, Supplier<String> messageSupplier) {
        if (ObjectUtils.isEmpty(array)) {
            throw new AssertsException(nullSafeGet(messageSupplier));
        }
    }

    public static void notEmpty(@Nullable Object[] array) {
        notEmpty(array, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "[Assertion failed] - this array must not be empty: it must contain at least 1 element"));
    }

    public static void noNullElements(@Nullable Object[] array, String message) {
        if (array != null) {
            int var3 = array.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                Object element = array[var4];
                if (element == null) {
                    throw new AssertsException(message);
                }
            }
        }

    }

    public static void noNullElements(@Nullable Object[] array, Supplier<String> messageSupplier) {
        if (array != null) {
            int var3 = array.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                Object element = array[var4];
                if (element == null) {
                    throw new AssertsException(nullSafeGet(messageSupplier));
                }
            }
        }

    }

    public static void noNullElements(@Nullable Object[] array) {
        noNullElements(array, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "[Assertion failed] - this array must not contain any null elements"));
    }

    public static void notEmpty(@Nullable Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new AssertsException(message);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, Supplier<String> messageSupplier) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new AssertsException(nullSafeGet(messageSupplier));
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection) {
        notEmpty(collection, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "[Assertion failed] - this collection must not be empty: it must contain at least 1 element"));
    }

    public static void notEmpty(@Nullable Map<?, ?> map, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new AssertsException(message);
        }
    }

    public static void notEmpty(@Nullable Map<?, ?> map, Supplier<String> messageSupplier) {
        if (CollectionUtils.isEmpty(map)) {
            throw new AssertsException(nullSafeGet(messageSupplier));
        }
    }

    public static void notEmpty(@Nullable Map<?, ?> map) {
        notEmpty(map, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "[Assertion failed] - this map must not be empty; it must contain at least one entry"));
    }

    public static void isInstanceOf(Class<?> type, @Nullable Object obj, String message) {
        notNull(type, (String) org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "Type to check against must not be null"));
        if (!type.isInstance(obj)) {
            instanceCheckFailed(type, obj, message);
        }

    }

    public static void isInstanceOf(Class<?> type, @Nullable Object obj, Supplier<String> messageSupplier) {
        notNull(type, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "Type to check against must not be null"));
        if (!type.isInstance(obj)) {
            instanceCheckFailed(type, obj, nullSafeGet(messageSupplier));
        }

    }

    public static void isInstanceOf(Class<?> type, @Nullable Object obj) {
        isInstanceOf(type, obj, "");
    }

    public static void isAssignable(Class<?> superType, @Nullable Class<?> subType, String message) {
        notNull(superType, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "Super type to check against must not be null"));
        if (subType == null || !superType.isAssignableFrom(subType)) {
            assignableCheckFailed(superType, subType, message);
        }

    }

    public static void isAssignable(Class<?> superType, @Nullable Class<?> subType, Supplier<String> messageSupplier) {
        notNull(superType, org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(),
                "Super type to check against must not be null"));
        if (subType == null || !superType.isAssignableFrom(subType)) {
            assignableCheckFailed(superType, subType, nullSafeGet(messageSupplier));
        }

    }

    public static void isAssignable(Class<?> superType, Class<?> subType) {
        isAssignable(superType, subType, "");
    }

    private static void instanceCheckFailed(Class<?> type, @Nullable Object obj, @Nullable String msg) {
        String className = obj != null ? obj.getClass().getName() : "null";
        String result = "";
        boolean defaultMessage = true;
        if (StringUtils.hasLength(msg)) {
            if (endsWithSeparator(msg)) {
                result = msg + " ";
            } else {
                result = messageWithTypeName(msg, className);
                defaultMessage = false;
            }
        }

        if (defaultMessage) {
            result = result + "Object of class [" + className + "] must be an instance of " + type;
        }

        throw new AssertsException(org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(), result));
    }

    private static void assignableCheckFailed(Class<?> superType, @Nullable Class<?> subType, @Nullable String msg) {
        String result = "";
        boolean defaultMessage = true;
        if (StringUtils.hasLength(msg)) {
            if (endsWithSeparator(msg)) {
                result = msg + " ";
            } else {
                result = messageWithTypeName(msg, subType);
                defaultMessage = false;
            }
        }

        if (defaultMessage) {
            result = result + subType + " is not assignable to " + superType;
        }

        throw new AssertsException(org.apache.commons.lang3.StringUtils.defaultIfBlank(getDefaultMessage(), result));
    }

    private static boolean endsWithSeparator(String msg) {
        return msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith(".");
    }

    private static String messageWithTypeName(String msg, @Nullable Object typeName) {
        return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
    }

    @Nullable
    private static String nullSafeGet(@Nullable Supplier<String> messageSupplier) {
        return messageSupplier != null ? messageSupplier.get() : null;
    }
}
