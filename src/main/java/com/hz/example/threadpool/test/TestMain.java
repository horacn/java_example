package com.hz.example.threadpool.test;

import java.util.concurrent.TimeUnit;

/**
 * 单线程执行耗时测试
 *
 * Created by hezhao on 2018/7/25 14:59.
 */
public class TestMain {

    static int count = 0;

    public static void main(String[] args) {

        // 开始时间
        long start = System.currentTimeMillis();

        // 单线程执行
        while (true) {
            System.out.println(Thread.currentThread().getName() + " - 正在运行 - ["+ (System.currentTimeMillis() - start) / 1000.0 +"秒] - "  + (++count) + "次执行");
            try {
                // 模拟耗时操作，50毫秒
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
