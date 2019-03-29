package com.xin.springboot.controller;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;

/**
 * Created by xsl on 2019/3/28.
 */
@Controller
public class CommonErrorController extends BasicErrorController {
    public CommonErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }
}
