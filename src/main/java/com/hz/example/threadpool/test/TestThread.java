package com.hz.example.threadpool.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 多线程执行耗时测试
 *
 * 对比单线程(TestMain)，效率要高很多。
 *
 * Created by hezhao on 2018/7/25 14:59.
 */
public class TestThread {

    static int count = 0;

    public static void main(String[] args) {

        // 固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        // 开始时间
        long start = System.currentTimeMillis();

        Runnable runnable = () -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " - 正在运行 - ["+ (System.currentTimeMillis() - start) / 1000.0 +"秒] - "  + (++count) + "次执行");
                try {
                    // 模拟耗时操作，50毫秒
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 开启4个线程
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);

    }

}
