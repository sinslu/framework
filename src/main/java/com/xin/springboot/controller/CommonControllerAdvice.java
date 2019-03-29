package com.xin.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by xsl on 2019/3/28.
 * 处理controller 发生的异常
 */
@ControllerAdvice
@Slf4j
public class CommonControllerAdvice extends ResponseEntityExceptionHandler{

    /**
     * 处理指定类型的exception
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e){
        e.printStackTrace();
        ModelAndView modelAndView=new ModelAndView("error/404");
        return modelAndView;
    }
}
