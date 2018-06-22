package com.hz.example.threadpool.pool.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.AbstractScheduledService;

/**
 * AbstractScheduledService impl
 * AbstractScheduledService类用于在运行时处理一些周期性的任务。
 * @author Zhao.He
 *
 */
public class MyAbstractScheduledService extends AbstractScheduledService{

	@Override
	protected void runOneIteration() throws Exception {
//		isRunning()
		
	}

	@Override
	protected Scheduler scheduler() {
//		AbstractScheduledService.Scheduler.newFixedDelaySchedule(1000, 3000, TimeUnit.MILLISECONDS);
//		AbstractScheduledService.Scheduler.newFixedRateSchedule(1, 3, TimeUnit.MINUTES);
		return null;
	}

	@Override
	protected void startUp() throws Exception {
		super.startUp();
	}

	@Override
	protected void shutDown() throws Exception {
		super.shutDown();
	}

	
}
