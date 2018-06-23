package com.hz.example.logic;

import org.junit.Test;

/** 各种图案的打印
 * @Author hezhao
 * @Time 2018-06-23 23:21
 * @Description 无
 * @Version V 1.0
 */
public class TestPattern {
    /**
     * 输出9*9口诀
     */
    @Test
    public void test1(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }

    /**

     *
     * *
     * * *
     * * * *
     * * * * *
     * * * * * *
     * * * * * * *

     */
    @Test
    public void test2(){
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**

     * * * * * * *
     * * * * * *
     * * * * *
     * * * *
     * * *
     * *
     *

     */
    @Test
    public void test3(){
        for (int i = 7; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**

     *
     ***
     *****
     *******
     *****
     ***
     *

     */
    @Test
    public void test4(){
        for(int i=1; i<=4; i++) {
            for(int j=1; j<=2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=4; i>=1; i--) {
            for(int j=1; j<=2*i-3; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     菱形
     */
    @Test
    public void test5(){
        int i, j;
        for(i=1; i<=4; i++) {
            for(int k=1; k<=4-i; k++)
                System.out.print(" ");
            for(j=1; j<=2*i-1; j++)
                System.out.print("*");
            System.out.println();
        }
        for(i=4; i>=1; i--) {
            for(int k=1; k<=5-i; k++)
                System.out.print(" ");
            for(j=1; j<=2*i-3; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}