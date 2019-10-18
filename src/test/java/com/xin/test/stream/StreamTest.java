package com.xin.test.stream;

import com.alibaba.fastjson.JSONObject;
import com.xin.test.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xsl on 2019/8/29.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> title= Arrays.asList("java","in","action");
        List<Employee> employeeList=title.stream().map(s -> {
            Employee e=new Employee();
            e.setName(s);
            return e;
        }).collect(Collectors.toList());

        System.out.println(JSONObject.toJSONString(employeeList));
        //流只能遍历一次(消费一次)
        //s.forEach(t-> System.out.println(t));
        // s.forEach(t-> System.out.println(t));
    }
}
