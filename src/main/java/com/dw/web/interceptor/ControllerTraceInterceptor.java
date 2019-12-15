package com.dw.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Controller 请求跟踪日志记录
 */
@Component
public class ControllerTraceInterceptor extends HandlerInterceptorAdapter {
    private final static Logger logger = LoggerFactory.getLogger(ControllerTraceInterceptor.class);

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        try {
            long RunStartTime = (Long) arg0.getAttribute("RunStartTime");
            long RunEndTime = System.currentTimeMillis();
            long ExecuteTime = RunEndTime - RunStartTime;
            if (arg2 instanceof HandlerMethod) {
                if (ExecuteTime > 1500) {
                    logger.warn("耗时时间:{}ms", ExecuteTime);
                } else {
                    logger.info("耗时时间:{}ms", ExecuteTime);
                }
            }
        } catch (Exception e) {
            logger.warn("", e);
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
                             Object arg2) throws Exception {

        try {
            long RunStartTime = System.currentTimeMillis();
            request.setAttribute("RunStartTime", RunStartTime);

            if (arg2 instanceof HandlerMethod) {
                HandlerMethod h = (HandlerMethod) arg2;

                if (h.getBean().getClass().getName().indexOf("$") > 0) {
                    logger.info("请求类:{}", h.getBean().getClass().getName().substring(0, h.getBean().getClass().getName().indexOf("$")));
                } else {
                    logger.info("请求类:{}", h.getBean().getClass().getName());
                }
                logger.info("请求参数:{}", getParamString(request.getParameterMap()));
            }
            logger.info("请求路径:{}", request.getRequestURL());
        } catch (Exception e) {
            logger.warn("", e);
        }

        return true;
    }

    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for (Entry<String, String[]> e : map.entrySet()) {
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if (value != null && value.length == 1) {
                sb.append(value[0]).append("\t");
            } else {
                sb.append(Arrays.toString(value)).append("\t");
            }
        }
        return sb.toString();
    }

}
