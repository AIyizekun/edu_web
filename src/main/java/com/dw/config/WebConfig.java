package com.dw.config;

import com.dw.web.interceptor.ControllerTraceInterceptor;
import com.dw.web.resolver.DateArgumentResolver;
import com.dw.web.resolver.DateConverter;
import com.dw.web.resolver.LongListConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * WebMvc配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private Environment environment;
    @Value("${spring.profiles.active}")
    private String      profiles;

    @Autowired(required = false)
    private ControllerTraceInterceptor controllerTraceInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //如果在windows环境下的静态资源
        if (StringUtils.containsIgnoreCase(environment.getProperty("os.name"), "Windows")) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
            return;
        }
        //在linux环境下的静态资源
        registry.addResourceHandler("/static/**").addResourceLocations("file:static/");
        registry.addResourceHandler("/public/**").addResourceLocations("file:public/");

    }

    /**
     * 参数解析
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new DateArgumentResolver());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
        registry.addConverter(new LongListConverter());
    }

    /**
     * 拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //prod不拦截
        if (this.controllerTraceInterceptor != null && !StringUtils.equals("prod", profiles)) {
            registry.addInterceptor(this.controllerTraceInterceptor)
                    .addPathPatterns("/**").excludePathPatterns(
                            "/**/*.js",
                    "/**/*.css",
                    "/**/*.tff",
                    "/**/*.eot",
                    "/**/*.woff",
                    "/**/*.svg",
                    "/**/*.woff2").order(1);
        }
    }
}