package com.xin.test;

/**
 * Created by xsl on 2019/8/21.
 */
public class CommonTest {
    public static void main(String[] args) {
        System.out.println(args);
        //System.out.println(0b1001);
        //System.out.println(1<<8);
        //00000000
        //System.out.println((1<<7)+(1<<6)+(1<<5)+(1<<4)+(1<<3)+(1<<2)+2+1);

       // System.out.println(1<<35);
       // System.out.println(1<<3);

        outer_flag:
        for(int i=0;i<100;i++){
            System.out.println("outer loop");
            inner_flag:
            for(int j=0;j<100;j++){
                System.out.println("inner loop");
                if(j==10){
                    break inner_flag;
                }
            }
            if(i==5){
                break outer_flag;
            }
        }
    }
}
