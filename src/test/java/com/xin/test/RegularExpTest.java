package com.xin.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xsl on 2019/8/28.
 * 正则表达式
 */
public class RegularExpTest {
    public static String parseHtml(String path){
        StringBuilder sb=new StringBuilder();
        try(InputStream inputStream=Files.newInputStream(Paths.get(path), StandardOpenOption.READ)){
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line=br.readLine()) !=null){
                sb.append(line);
            }
        }catch (Exception e){

        }
        return sb.toString();
    }
    public static String parseHtml2(String url){
        StringBuilder sb=new StringBuilder();
        try(InputStreamReader inputStream=new InputStreamReader(new URL(url).openStream(), StandardCharsets.UTF_8)){
            BufferedReader br=new BufferedReader(inputStream);
            String line;
            while((line=br.readLine()) !=null){
                sb.append(line);
            }
        }catch (Exception e){

        }
        return sb.toString();
    }

    public static void main(String[] args) {
/*        String input="ceshi11:59ambcd";
        Pattern pattern=Pattern.compile("(([1-9]|1[0-2]):([0-5][0-9]))[ap]m");
        Matcher matcher=pattern.matcher(input);
        if (matcher.find()){
            System.out.println("匹配到的字符:"+matcher.group());
            System.out.println("开始索引+"+matcher.start());
            System.out.println("结束的位置:"+matcher.end());
            int groupCount=matcher.groupCount();
            for(int i=0;i<=groupCount;i++){
                System.out.println("group-"+i+":"+matcher.group(i));
            }
        }*/

        String input=parseHtml2("http://ued.t.huijiaoyun.com/tianyu_edu_dev/system/mailList/classBackstage/list1.1.html");
        //String input=parseHtml("test.html");
        String regex="<a\\s+href\\s*=\\s*(\"[^\"]*\")";
        Pattern pattern=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(input);
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }
    }
}
