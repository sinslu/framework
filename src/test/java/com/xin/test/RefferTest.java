package com.xin.test;

import com.xin.test.model.Employee;

/**
 * Created by xsl on 2019/8/22.
 */
public class RefferTest {

    public static <T> T method1(T t){
        return t;
    }

    public static void swap(Employee a,Employee b){
        Employee temp=a;
        a=b;
        b=temp;
        System.out.println("a的名称："+a.getName());
        System.out.println("b的名称："+b.getName());
    }

    public static void main(String[] args) {
        Employee e1=new Employee("Alice");
        Employee e2=new Employee("Bob");
        swap(e1,e2);
        System.out.println(e1.getName());
        System.out.println(e2.getName());
    }
}
