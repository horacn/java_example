package com.hz.example.threadpool.pool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行。
 */
public class TestScheduledThreadPoolExecutor {
	public static void main(String[] args) {
		
//		ExecutorService pool = Executors.newScheduledThreadPool(3);
		
		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(10);

        // 延迟3秒执行
        exec.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);

        exec.scheduleAtFixedRate(new Runnable() { //表示延迟1秒后每2秒执行一次，证明两者是互不影响的
                      @Override
                      public void run() {
                           System.out.println(System.nanoTime());
                      }
                  }, 1000, 2000, TimeUnit.MILLISECONDS);

        // 添加线程任务的功能还是一样的。
        for (int i = 0; i < 5; i++) {
            Thread t1 = new MyThread();
            exec.execute(t1);
        }
        
    }
}
