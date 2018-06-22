package com.hz.example.threadpool.pool.guava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

/**
 * AbstractExecutionThreadService 通过单线程处理启动、运行、和关闭等操作。
 * AbstractExecutionThreadService impl
 * @author Zhao.He
 *
 */
public class MyAbstractExecutionThreadService extends AbstractExecutionThreadService{

	@Override
	protected void run() throws Exception {
		
		while(isRunning()){
			//if ...
			System.out.println("AbstractExecutionThreadService ::　run");
		}
		
	}

	
	//重载triggerShutdown()方法让run()方法结束返回。
	@Override
	protected void triggerShutdown() {
		super.triggerShutdown();
	}

	//un should
	@Override
	protected void startUp() throws Exception {
		super.startUp();
	}

	//un should
	@Override
	protected void shutDown() throws Exception {
		super.shutDown();
	}

	
}
