package com.xin.test;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by xsl on 2019/8/23.
 */
public class CollectionTest {
    public static void main(String[] args){
/*        List<Person> personList=new ArrayList<>();
        personList.add(new Person("1","名称1"));
        personList.add(new Person("2","名称2"));
        personList.add(new Person("3","名称3"));
        personList.add(new Person("4","名称4"));
        personList.add(new Person("5","名称5"));
        personList.add(new Person("6","名称6"));
        personList.add(new Person("7","名称7"));
        personList.add(new Person("8","名称8"));

        List<String> ids=personList.stream().map(Person::getId).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(ids));*/

        //List<Integer> nums=Stream.iterate(2,p->p*2).limit(10).collect(Collectors.toList());
        //System.out.println(nums);
        System.out.println(System.getProperty("user.dir"));
        try(InputStream fileInputStream=Files.newInputStream(Paths.get("target","classes","application.yml"), StandardOpenOption.READ)){
            byte[] b=new byte[1024];
            while (fileInputStream.read(b) !=-1){
                System.out.println(new String(b));
            }
        }catch (FileNotFoundException e){

        }catch (IOException ioe){

        }
    }
}

class Person{
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
