package com.hz.example.thread.sync;

/**
 * 线程不安全
 */
class Dog2 extends Thread {
    // 定义线程共享数据
    private int t = 100;

    @Override
    public void run() {
        // TODO：死循环，暂不处理
        while (true) {
        	System.out.println("进入线程：" + Thread.currentThread().getName());
        			
            if (t > 0) {
            	try {
					Thread.sleep(100);
					System.out.println("当前线程：" + Thread.currentThread().getName() + "---" + t--);
				} catch (Exception e) {
					// TODO 暂不处理异常
				}          
            }
        }
    }
}

public class ss2 {
    public static void main(String[] args) {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        Dog2 dog = new Dog2();

        Thread thread = new Thread(dog);
        Thread thread2 = new Thread(dog);
        thread.start();
        thread2.start();

    }
}