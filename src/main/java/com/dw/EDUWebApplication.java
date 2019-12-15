package com.dw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SpringBoot启动类
 */
@SpringBootApplication
@ServletComponentScan("com.dw.web.listener")
public class EDUWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EDUWebApplication.class, args);
    }

}