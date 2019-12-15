package com.dw.web.listener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * spring boot 启动成功事件监听
 *
 * @Author yangjunxiong
 * @Date 2018/3/23
 */
@Component
public class SpringStartListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger      logger = LoggerFactory.getLogger(SpringStartListener.class);
    @Autowired
    private              Environment environment;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        try {
            init(contextRefreshedEvent.getApplicationContext());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (StringUtils.containsIgnoreCase(environment.getProperty("os.name"), "Windows")) {
            logger.info("================ edu_web模块启动成功 ({})==========================",
                    environment.getActiveProfiles()[0]);
        } else {
            logger.info("================edu_web system running ({})==========================",
                    environment.getActiveProfiles()[0]);
        }

    }

    /**
     * 初始化加载项目
     *
     * @param context
     */
    private void init(ApplicationContext context) throws Exception {
        // TODO YJX 2019/12/15 12:57 初始化请在这里写

    }


}
