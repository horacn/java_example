package com.hz.example.logic.number;

import java.util.Scanner;

/** 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
 * @Author hezhao
 * @Time 2018-06-23 23:03
 * @Description 无
 * @Version V 1.0
 */
public class TestCommonDivisor {
    public static void main(String args[]) throws Exception {
        // 取得输入值
        Scanner chin = new Scanner(System.in);
        System.out.println("请输入两个自然数，一行一个：");
        int a = chin.nextInt(), b = chin.nextInt();
        int c = gcd(a, b);
        System.out.println("最小公倍数：" + a * b / c + "\n最大公约数：" + c);
    }

    public static int gcd(int m, int n) {
        while (true) {
            if ((m = m % n) == 0)
                return n;
            if ((n = n % m) == 0)
                return m;
        }
    }
}