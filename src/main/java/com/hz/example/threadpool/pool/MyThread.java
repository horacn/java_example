package com.hz.example.threadpool.pool;

public class MyThread extends Thread{

	@Override
	public void run() {
		System.out.println(this.currentThread().getName()+" 在运行");
		
	}
	
}
