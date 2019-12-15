package com.dw.web.resolver;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.text.ParseException;
import java.util.Date;

public class DateArgumentResolver implements HandlerMethodArgumentResolver {
    private static final Logger logger = LoggerFactory.getLogger(DateArgumentResolver.class);

    private String[] patterns = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm"};

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz.equals(Date.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String paramName = parameter.getParameterName();
        if (StringUtils.isBlank(paramName)) {
            return null;
        }
        String paramValue = webRequest.getParameter(paramName);
        if (StringUtils.isBlank(paramValue)) {
            return null;
        }

        //如果传的是时间戳
        try {
            if (StringUtils.isNumeric(paramValue)) {
                Long timestamp = Long.valueOf(paramValue);
                return new Date(timestamp);
            }
        } catch (NumberFormatException e) {
            logger.error("时间格式化出错:{} -- {}", paramValue, webRequest.toString());
            return null;
        }

        //传的是时间
        Date date = null;
        try {
            date = DateUtils.parseDate(paramValue, patterns);
        } catch (ParseException e) {
            logger.error("时间格式化出错:{} -- {}", paramValue, webRequest.toString());
        }

        return date;
    }

    /**
     * 默认解析："yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm"
     *
     * @param patterns
     */
    public void setPatterns(String[] patterns) {
        this.patterns = patterns;
    }
}
