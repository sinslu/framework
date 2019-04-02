package com.xin.dubbo.consumer;

import com.xin.dubbo.api.GreetingService;
import com.xin.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xsl on 2019/4/1.
 */
@RestController
public class TestDubboController {

    @Reference(interfaceClass = HelloService.class, version = "1.0.0",timeout = 2000)
    private HelloService helloService;

    /**
     * @since 2.7.1
     */
    //@Reference(interfaceClass = GreetingService.class, version = AnnotationConstants.VERSION, methods = {@Method(name = "greeting", timeout = 250, retries = 1)})
    @Reference(interfaceClass = GreetingService.class,version = "1.0.0",timeout = 2000)
    private GreetingService greetingService;

    @RequestMapping("/doSayHello")
    public String doSayHello(String name) {
        try {
            return helloService.sayHello(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }
    @RequestMapping("/doSayGoodbye")
    public String doSayGoodbye(String name) {

        try {
            return helloService.sayGoodbye(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }
    @RequestMapping("/doGreeting")
    public String doGreeting(String name) {

        try {
            return greetingService.greeting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }
    @RequestMapping("/replyGreeting")
    public String replyGreeting(String name) {
        try {
            return greetingService.replyGreeting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }

}
