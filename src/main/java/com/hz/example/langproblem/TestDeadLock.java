package com.hz.example.langproblem;

/**
 * 写一个简单的程序 实现死锁。
 * @author hezhao
 * @Time   2016年7月15日 上午9:37:18
 * @Description 无
 * @Version V 1.0
 */
public class TestDeadLock {
	 public void run() {
	        MyThread mt = new MyThread();
	        new Thread(mt, "张三").start();
	        new Thread(mt, "李四").start();
	    }
	     
	    class MyThread implements Runnable {
	        private Object o1 = new Object();
	        private Object o2 = new Object();
	        private boolean flag = true;
	         
	 
	        @Override
	        public void run() {
	            if (flag) {
	                flag = false;
	                synchronized (o1) {
	                    System.out.println(Thread.currentThread().getName() + " have o1");
	                    try {
	                        Thread.sleep(100);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                    synchronized (o2) {
	                        System.out.println(Thread.currentThread().getName() + " have o2");
	                    }
	                }
	            } else {
	                flag = true;
	                synchronized (o2) {
	                    System.out.println(Thread.currentThread().getName() + " have o2");
	                    try {
	                        Thread.sleep(100);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                    synchronized (o1) {
	                        System.out.println(Thread.currentThread().getName() + " have o1");
	                    }
	                }
	            }
	        }
	    }
	     
	    public static void main(String[] args) {
	        new TestDeadLock().run();
	    }
}
