package com.hz.example.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTest2 {
	 public static void main(String[] args) {
		 for (int i = 0; i < 100; i++) {
	    		Thread1 t = new Thread1();
	    		//t.run(); //这里也不能直接调用方法
	    		t.start();
			}

        for (int i = 0; i < 10; i++) {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
        	String now = sdf.format(new Date());
        	System.out.println("main:"+now);
		}
	}
}

// 尽量使用实现Runnnable接口，因为接口比较灵活
class Thread1 extends Thread{
	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
		String now = sdf.format(new Date());

		System.out.println("Thread-----:"+now);
	}
}
