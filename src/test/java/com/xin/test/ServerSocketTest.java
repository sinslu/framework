package com.xin.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by xsl on 2019/8/28.
 */
public class ServerSocketTest {
    public static void main(String[] args) throws IOException{
        try (ServerSocket serverSocket = new ServerSocket(8189)){
             try(Socket income=serverSocket.accept()){
                 InputStream inputStream=income.getInputStream();
                 OutputStream outputStream=income.getOutputStream();
                 try(Scanner scanner=new Scanner(inputStream,"UTF-8")){
                     PrintWriter writer=new PrintWriter(new OutputStreamWriter(outputStream,"UTF-8"),true);
                     writer.println("hello,enter bye to exit");
                     boolean done=false;
                     while (!done && scanner.hasNextLine()){
                         String line=scanner.nextLine();
                         writer.println(line);
                         System.out.println("接收："+line);
                         if(line.trim().equalsIgnoreCase("bye")) done=true;
                     }
                 }

             }
        }
    }
}
