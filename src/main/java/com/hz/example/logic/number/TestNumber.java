package com.hz.example.logic.number;

import org.junit.Test;

/** 关于数字的问题
 * @Author hezhao
 * @Time 2018-06-23 23:11
 * @Description 无
 * @Version V 1.0
 */
public class TestNumber {

    /**
     * 题目：一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程   找出1000以内的所有完数。
     */
    @Test
    public void test1(){
        int s;
        for(int i=1; i<=1000; i++) {
            s = 0;
            for(int j=1;j<i;j++) {
                if (i % j == 0) {
                    s = s + j;
                }
            }
            if(s == i) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    /**
     * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
     */
    @Test
    public void test2() {
        double s = 0;
        double t = 100;
        for(int i=1; i<=10; i++) {
            s += t;
            t = t/2;
        }
        System.out.println(s);
        System.out.println(t);
    }

    /**
     * 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
     * 1.程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去掉不满足条件的排列。
     */
    @Test
    public void test3() {
        int i, j, k;
        int t = 0;
        for(i=1; i<=4; i++) {
            for (j = 1; j <= 4; j++) {
                for (k = 1; k <= 4; k++) {
                    if (i != j && j != k && i != k) {
                        t += 1;
                        System.out.println(i * 100 + j * 10 + k);
                    }
                }
            }
        }
        System.out.println ("一共:" + t + "个");
    }

    /**
     * 题目：猴子吃桃问题
     * 猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个。
     * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     * 以后每天早上都吃了前一天剩下的一半零一个。
     * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
     *
     * 1.程序分析：采取逆向思维的方法，从后往前推断。
     */
    @Test
    public void test4() {
        System.out.println("第一天共摘了 " + total(1));
    }

    int total(int day){
        if(day == 10){
            return 1;
        } else {
            return (total(day + 1) + 1) * 2;
        }
    }

    /**
     * 题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多大？
     * 1.程序分析：利用递归的方法，递归分为回推和递推两个阶段。要想知道第五个人岁数，需知道第四人的岁数，依次类推，推到第一人（10岁），再往回推。
     */
    @Test
    public void test5() {
        System.out.println("第五个的年龄为:" + getAge(5));
    }

    int getAge(int n){
        if (n == 1){
            return 10;
        }
        return 2 + getAge(n-1);
    }

    /**
     * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
     */
    @Test
    public void test6() {
        System.out.println(isPalindrom(12321));
        System.out.println(isPalindrom(12311));
    }

    boolean isPalindrom(long l){
        int[] a = new int[5];
        int[] b = new int[5];

        boolean is =false;
        for (int i = 4; i >= 0; i--) {
            a[i] = (int) (l / (long) Math.pow(10, i));
            l =(l % ( long) Math.pow(10, i));
        }
        for(int i=0,j=0; i<5; i++, j++) {
            b[j] = a[i];
        }
        for(int i=0,j=4; i<5; i++, j--) {
            if(a[i] != b[j]) {
                is = false;
                break;
            } else {
                is = true;
            }
        }
        return is;
    }

}