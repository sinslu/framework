package com.xin.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xsl on 2019/8/22.
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println("list :"+ JSONObject.toJSONString(list));
        list.removeIf((s)-> "c".equals(s));
        System.out.println("list removed :"+JSONObject.toJSONString(list));
    }
}
