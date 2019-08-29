package com.xin.test;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by xsl on 2019/8/28.
 */
public class SocketTest {
    public static void main(String[] args) {
        try(Socket s=new Socket("localhost",8189);
            Scanner scanner=new Scanner(s.getInputStream(), StandardCharsets.UTF_8.toString());
            PrintWriter writer=new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"),true);
        ){
            System.out.println("连接服务器返回信息:"+scanner.nextLine());
            System.out.println("请输入:");
            Scanner in=new Scanner(System.in);
            while (true){
                String line=in.nextLine();
                writer.println(line);
                String back=scanner.nextLine();
                System.out.println("服务端返回:"+back);
                if("bye".equalsIgnoreCase(back.trim())){
                    break;
                }
            }
        }catch (Exception e){

        }
    }
}
