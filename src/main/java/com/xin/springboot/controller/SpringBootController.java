package com.xin.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xsl on 2019/3/27.
 */
@RestController
@RequestMapping("test")
public class SpringBootController {
    @RequestMapping("home")
    public String home(){
        return "home";
    }
}
