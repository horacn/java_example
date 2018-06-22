package com.hz.example.javafeatures.java8;

/**
 * 接口的默认方法
 * @author hezhao
 * @Time   2016年3月2日 下午5:59:18
 * @Description 无
 * @version V 1.0
 */
public interface Formula {
    //计算
    double calculate(double a);

    //开平方
    default double sqrt(double a) {
        return Math.sqrt(a);
    }

    //平方
    default double square(double a) {
//        return a*a;
        return Math.pow(a, 2);
    }

    //任意一个数的n次方
    default double power(double a,double n) {
//    	double result = a;
//        for (int i = 0; i < n-1; i++) {
//        	result*=a;
//		}
//        return result;
        return Math.pow(a, n);
    }

    //Java8里接口可以带静态方法
    static void print(){
        System.out.println("xxx");
    }
}