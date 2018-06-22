package com.hz.example.threadpool.pool;

public class MyThread2 extends Thread{

	@Override
	public void run() {
		System.out.println("_ "+this.currentThread().getName()+" 在运行");
	}
	
}
