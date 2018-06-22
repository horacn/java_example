package com.hz.example.threadpool.pool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPoolExecutor {
	public static void main(String[] args) {
		
//		ExecutorService pool = Executors.newScheduledThreadPool(3);
		
		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(10);
        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间就触发异常
                      @Override
                      public void run() {
                           //throw new RuntimeException();
                           System.out.println("================");
                      }
                  }, 1000, 5000, TimeUnit.MILLISECONDS);
        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间打印系统时间，证明两者是互不影响的
                      @Override
                      public void run() {
                           System.out.println(System.nanoTime());
                      }
                  }, 1000, 2000, TimeUnit.MILLISECONDS);
        
        Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		Thread t3 = new MyThread();
		Thread t4 = new MyThread();
		Thread t5 = new MyThread();
		exec.execute(t1);
		exec.execute(t2);
		exec.execute(t3);
		exec.execute(t4);
		exec.execute(t5);
        
    }
}
