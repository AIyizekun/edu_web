package com.dw.web.resolver;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class LongListConverter implements Converter<String, List<Long>> {
    private static final Logger logger = LoggerFactory.getLogger(LongListConverter.class);
    @Override
    public List<Long> convert(String s) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        List<Long> list = new ArrayList<>(16);
        try {
            for (String item : StringUtils.split(s,",")) {
                list.add(Long.valueOf(item));
            }
            return list;
        } catch (NumberFormatException e) {
            logger.error("String 转成 List<Long> 失败：{}",s);
            return null;
        }
    }

}
