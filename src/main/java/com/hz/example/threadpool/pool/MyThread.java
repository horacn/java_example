package com.hz.example.threadpool.pool;

public class MyThread extends Thread{

	@Override
	public void run() {
		System.out.println("[MyThread] - " + this.currentThread().getName()+" 在运行");
		
	}
	
}
