package com.dw.controller.common.verify;


import com.dw.exception.EDUException;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * 验证接口
 *
 * @Author yangjunxiong
 * @Date 2018/3/28
 */
public interface Verify {

    /**
     * 选择性验证
     *
     * @param skipNull     是否跳过空字段的验证
     * @param exceptFields 排除验证的字段
     */
    @SuppressWarnings("unchecked")
    default Optional<String> verify(boolean skipNull, String... exceptFields) throws EDUException {
        String errorMsg = ValidatorUtils.validate(this, skipNull, exceptFields);
        if (StringUtils.isNotBlank(errorMsg)) {
            throw new EDUException(errorMsg);
        }
        //校验通过
        return Optional.empty();
    }

    /**
     * 如果没有指定验证的字段，那么验证所有字段
     *
     * @param fields 要验证的字段
     * @return
     */
    @SuppressWarnings("unchecked")
    default Optional<String> verify(String... fields) throws EDUException {
        String errorMsg = ValidatorUtils.validate(this, fields);
        if (StringUtils.isNotBlank(errorMsg)) {
            throw new EDUException(errorMsg);
        }
        //校验通过
        return Optional.empty();
    }

    /**
     * 选择性验证,如果验证失败则抛出【SZException】
     *
     * @param skipNull     是否跳过空字段的验证
     * @param exceptFields 排除验证的字段
     * @throws EDUException
     */
    default void verifyThrow(boolean skipNull, String... exceptFields) throws EDUException {
        Optional<String> notify = verify(skipNull, exceptFields);
        if (notify.isPresent()) {
            throw new EDUException(notify.get());
        }
    }

    /**
     * 如果没有指定验证的字段，那么验证所有字段，如果验证失败则抛出【SZException】
     *
     * @param fields 要验证的字段
     * @return
     * @throws EDUException
     */
    default void verifyThrow(String... fields) throws EDUException {
        Optional<String> notify = verify(fields);
        if (notify.isPresent()) {
            throw new EDUException(notify.get());
        }
    }

    /**
     * 如果存在错误，就抛出自定义异常
     *
     * @param exceptionSupplier
     * @param <X>
     * @throws X
     */
    default <X extends Throwable> void verifyThrow(Supplier<? extends X> exceptionSupplier) throws X {
        Optional<String> notify = verify();
        if (notify.isPresent()) {
            X throwable = exceptionSupplier.get();
            ReflectUtils.setFieldValue(throwable, "detailMessage", notify);
            throw throwable;
        }
    }

}
