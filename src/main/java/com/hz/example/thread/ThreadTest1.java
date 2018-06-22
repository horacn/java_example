package com.hz.example.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTest1 {
    public static void main(String[] args) {
    	for (int i = 0; i < 100; i++) {
    		Runnable1 r = new Runnable1();
    		//r.run();并不是线程开启，而是简单的方法调用
    		Thread t = new Thread(r);//创建线程
    		//t.run(); //如果该线程是使用独立的 Runnable 运行对象构造的，则调用该 Runnable 对象的 run 方法；否则，该方法不执行任何操作并返回。
    		t.start(); //线程开启
		}

        for (int i = 0; i < 10; i++) {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
        	String now = sdf.format(new Date());
        	System.out.println("main:"+now);
		}
    }
}

class Runnable1 implements Runnable{
    public void run() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
		String now = sdf.format(new Date());
        System.out.println("Thread-----:"+now);
    }
}