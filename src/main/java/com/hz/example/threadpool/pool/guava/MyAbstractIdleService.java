package com.hz.example.threadpool.pool.guava;

import com.google.common.util.concurrent.*;

/**
 * AbstractIdleService 类简单实现了Service接口、其在running状态时不会执行任何动作–因此在running时也不需要启动线程–但需要处理开启/关闭动作。
 * AbstractIdleService impl
 * @author Zhao.He
 *
 */
public class MyAbstractIdleService extends AbstractIdleService{

	/*
	 *  一个服务正常生命周期有：
		Service.State.NEW			新建
		Service.State.STARTING		启动
		Service.State.RUNNING		运行
		Service.State.STOPPING		停止
		Service.State.TERMINATED	结束
		Service.State.FAILED		失败
	 * */
	
	@Override
	protected void startUp() throws Exception {
//		isRunning()
		System.out.println("AbstractExecutionThreadService::startUp");
	}

	@Override
	protected void shutDown() throws Exception {
		System.out.println("AbstractExecutionThreadService::shutDown");
		
	}

}
