package com.hz.example.threadpool.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestFixedThreadPool {
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		ExecutorService pool = Executors.newFixedThreadPool(4);
		
		for (int i = 0; i < 30000; i++) {
			Thread t1 = new MyThread();
			pool.execute(t1);
			Thread t1x = new MyThread2();
			pool.execute(t1x);
		}
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) pool;
		//池的大小
		int poolSize = executor.getPoolSize();
		System.out.println(poolSize);
		//线程数
		int activeCount = executor.getActiveCount();
		System.out.println(activeCount);
		//最大线程数量
		int maximumPoolSize = executor.getMaximumPoolSize();
		System.out.println(maximumPoolSize);
		//核心线程数量
		int corePoolSize = executor.getCorePoolSize();
		System.out.println(corePoolSize);
		//队列
		BlockingQueue<Runnable> queue = executor.getQueue();
		System.out.println(queue);
		//已完成任务数的信息
		long completedTaskCount = executor.getCompletedTaskCount();
		System.out.println(completedTaskCount);
		//池中最大线程数
		int largestPoolSize = executor.getLargestPoolSize();
		System.out.println(largestPoolSize);
		
		
		
//		pool.shutdown();
		//close
		try {
			System.out.println("attempt to shutdown executor"); 
			//调用shutdown()方法后，如果您尝试向执行程序发送另一个任务，那么它将被拒绝，并且执行程序将抛出一个RejectedExecutionException异常。
			pool.shutdown(); 
			//awaitTermination（longtimeout，TimeUnitunit） ：此方法阻止调用线程，直到执行程序的任务结束或发生超时。 TimeUnit类是具有以下常量的枚举： DAYS ， HOURS ， MICROSECONDS等
			pool.awaitTermination(5, TimeUnit.SECONDS); 
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted"); 
		} finally { 
			//isTerminated（） ：如果调用了shutdown()或shutdownNow()方法，则该方法返回true，并且执行器完成将其关闭的过程。
			if (!pool.isTerminated()) {
				System.err.println("cancel non-finished tasks"); 
			} 
			//shutdownNow（） ：此方法立即关闭执行器。 它不执行挂起的任务。 它返回一个包含所有这些待处理任务的列表。 调用此方法时正在运行的任务继续执行，但该方法不会等待其完成。
			pool.shutdownNow(); 
			System.out.println("shutdown finished"); 
		} 
		
//		Callable<Integer> task = () -> { try { TimeUnit.SECONDS.sleep(1); return 123; } catch (InterruptedException e) { throw new IllegalStateException("task interrupted", e); } }; 
		
		
		long end = System.currentTimeMillis();
		System.out.println("TIME - "+(end - start) );
		
	}
}
