package com.xin.test.model;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xsl on 2019/8/22.
 */
public class Employee {
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        System.out.println(this);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
