package com.hz.example.logic;

/**
 * 鸡兔同笼，是中国古代著名典型趣题
 *
 * 今有雉兔同笼，上有三十五头，下有九十四足，问雉兔各几何？
 *
 * @Author hezhao
 * @Time 2018-06-23 22:09
 * @Description 无
 * @Version V 1.0
 */
public class TestChickenAndRabbit {
    public static void main(String[] args) {
        int c, r;
        int total = 35;

        for (c = 1; c <= total; c++) {
            for (r = 1; r <= total-c; r++) {
                if(c + r == 35 && c*2 + r*4 == 94){
                    System.out.println("鸡有"+c+"只，兔有"+r+"只");
                    break;
                }
            }
        }
    }
}