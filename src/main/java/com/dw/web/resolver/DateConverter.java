package com.dw.web.resolver;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

/**
 * @Date 2017/11/13
 */
public class DateConverter implements Converter<String, Date> {
    private static final Logger logger = LoggerFactory.getLogger(DateConverter.class);

    private String[] patterns = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm"};

    @Override
    public Date convert(String val) {
        if (StringUtils.isBlank(val)) {
            return null;
        }

        //如果传的是时间戳
        try {
            if (StringUtils.isNumeric(val)) {
                Long timestamp = Long.valueOf(val);
                return new Date(timestamp);
            }
        } catch (NumberFormatException e) {
            logger.error("时间格式化出错:{} ", val);
            return null;
        }


        //传的是时间格式
        try {
            return DateUtils.parseDate(val, patterns);
        } catch (ParseException e) {
            logger.error("时间格式化出错:{} ", val);
        }

        return null;
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
