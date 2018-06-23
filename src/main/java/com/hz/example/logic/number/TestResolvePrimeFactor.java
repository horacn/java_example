package com.hz.example.logic.number;

/**
 * 题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 */
public class TestResolvePrimeFactor {
    public TestResolvePrimeFactor() {

    }

    public void resolve(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.print(i + "*");
                resolve(n / i);
            }
        }
        System.out.print(n);
        System.exit(0); // 不能少这句，否则结果会出错
    }

    public static void main(String[] args) {
        TestResolvePrimeFactor c = new TestResolvePrimeFactor();
        String str = javax.swing.JOptionPane.showInputDialog("请输入N的值（输入exit退出）：");

        if (str == null || "exit".equals(str)){
            System.out.println("已退出。");
            System.exit(0);
        }

        try {
            int n = Integer.parseInt(str);
            System.out.print(n + "分解质因数：" + n + "=");
            c.resolve(n);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}