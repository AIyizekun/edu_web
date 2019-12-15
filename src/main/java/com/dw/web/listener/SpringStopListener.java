package com.dw.web.listener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * spring 容器停止事件监听
 *
 * @Author yangjunxiong
 * @Date 2018/3/24
 */
@Component
public class SpringStopListener implements ApplicationListener<ContextClosedEvent> {
    private static final Logger      LOGGER = LoggerFactory.getLogger(SpringStopListener.class);
    @Autowired
    private              Environment environment;


    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {

        LOGGER.info("edu_web shutdown ....");
        //在些等待一些线程池处理完成
        this.awaitTermination();

        if (StringUtils.containsIgnoreCase(environment.getProperty("os.name"), "Windows")) {
            LOGGER.info("================ edu_web模块关闭成功 ({}) ==========================",
                    environment.getActiveProfiles()[0]);
        } else {
            LOGGER.info("================edu_web system has closed ({})==========================",
                    environment.getActiveProfiles()[0]);
        }

    }

    private void awaitTermination() {
        //在此等待10秒
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            LOGGER.error("【停机】：{}", e.getMessage());
        }
    }
}
