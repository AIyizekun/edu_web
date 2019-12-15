package com.dw.web.resolver;

import java.lang.annotation.*;

/**
 * spring mvc参数解析类型，将json字符参数转化为对象
 * @date 2016年7月26日
 */
@Target(ElementType. PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JsonParam {
    boolean required() default true;
}
