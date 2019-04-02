package com.xin.springboot.utils;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by xsl on 2019/4/1.
 * 获取配置文件中的属性值
 */
@Component
public class SysConfig implements EnvironmentAware {
    private static Environment env;
    @Override
    public void setEnvironment(Environment environment) {
        SysConfig.env=environment;
    }

}
