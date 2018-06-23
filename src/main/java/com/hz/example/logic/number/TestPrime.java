package com.hz.example.logic.number;

/** 题目：判断2-200之间有多少个素数，并输出所有素数。
 * <br>
 * 程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。
 *
 * @Author hezhao
 * @Time 2018-06-23 22:45
 * @Description 无
 * @Version V 1.0
 */
public class TestPrime {

    public static void main(String args[]){
        for(int i=2; i<=200; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i <= x / 2; i++){
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}