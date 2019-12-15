package com.dw.controller.common.verify.annotation;

import java.lang.annotation.*;

/**
 * 切面验证
 *
 * @author yangjunxiong
 * @date 2019/1/26 14:11
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Repeatable(AspectValid.AspectValidList.class)
@Documented
public @interface AspectValid {

    /**
     * bean 名字
     *
     * @return
     */
    String beanName() default "";

    /**
     * 验证的方法
     *
     * @return
     */
    String method() default "";

    /**
     * spring express language
     *
     * @return
     */
    String EL() default "";

    /**
     * Defines several {@link AspectValid} annotations on the same element.
     *
     * @see AspectValid
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface AspectValidList {
        AspectValid[] value();
    }


}
