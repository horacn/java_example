package com.hz.example.langproblem;

import java.util.Objects;

/**
 * Created by hezhao on 2018/9/8 19:23
 */
public class TestEquals {

    public static void main(String[] args) {

        /*
        * 【强制】所有的相同类型的包装类对象之间值的比较，全部使用 equals 方法比较
            说明：对于 Integer var = ? 在-128 至 127 范围内的赋值， Integer 对象是在IntegerCache . cache 产生，会复用已有对象，这个区间内的 Integer 值可以直接使用==进行判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，
            推荐使用 equals 方法进行判断。
        * */
        Integer a = 128;
        Integer b = 128;

        System.out.println(a == b);
        System.out.println(a.equals(b));



        /*
        * 【强制】 Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用equals。
            正例：" test ".equals(object);
            反例：  object.equals("test");
            说明：推荐使用 java.util.Objects # equals（JDK 7 引入的工具类 ）
        * */
        System.out.println(Objects.equals(null, "99"));

    }

}
