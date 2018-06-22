package com.hz.example.thread.sync;

/**
 * 线程安全
 */
class Dog implements Runnable {
    // 定义线程共享数据
    private int t = 100;

    @Override
    public void run() {
        // TODO：死循环，暂不处理
        while (true) {
        	synchronized(Dog.class){
        		if (t > 0) {
        			try {
        				Thread.sleep(10);
        				System.out.println("当前线程：" + Thread.currentThread().getName() + "---" + t--);
        			} catch (Exception e) {
        				// TODO 暂不处理异常
        			}          
        		}
        	}
        }
    }
}

public class ss {
    public static void main(String[] args) {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        Dog dog = new Dog();

        Thread thread = new Thread(dog);
        Thread thread2 = new Thread(dog);
        thread.start();
        thread2.start();

    }
}