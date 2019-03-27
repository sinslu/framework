package com.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by xsl on 2019/3/27.
 */
@SpringBootApplication
public class APP  extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(APP.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(APP.class);
    }
}
