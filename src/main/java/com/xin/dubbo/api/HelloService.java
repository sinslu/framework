package com.xin.dubbo.api;

/**
 * Created by xsl on 2019/4/1.
 */
public interface HelloService {
    String sayHello(String name);

    default String sayGoodbye(String name) {
        return "Goodbye, " + name;
    }
}
