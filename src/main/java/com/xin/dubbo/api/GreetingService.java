package com.xin.dubbo.api;

import java.util.concurrent.CompletableFuture;

/**
 * Created by xsl on 2019/4/1.
 */
public interface GreetingService {
    String greeting(String name);

    default String replyGreeting(String name) {
        return "Fine, " + name;
    }

    default CompletableFuture<String> greeting(String name, byte signal) {
        return CompletableFuture.completedFuture(greeting(name));
    }
}
