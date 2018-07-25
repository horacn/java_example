package com.hz.example.threadpool.pool;

import java.util.concurrent.*;

/**
 * 创建一个指定工作线程数量的线程池。每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，则将提交的任务存入到池队列中。
 *
 * FixedThreadPool是一个典型且优秀的线程池，它具有线程池提高程序效率和节省创建线程时所耗的开销的优点。
 * 但是，在线程池空闲时，即线程池中没有可运行任务时，它不会释放工作线程，还会占用一定的系统资源。
 */
public class TestFixedThreadPool {
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		ExecutorService pool = Executors.newFixedThreadPool(4);

		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("[Runnable1] - " + Thread.currentThread().getName()+" 在运行");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("[Runnable2] - " + Thread.currentThread().getName()+" 在运行");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		// 线程池大小为4个，可以观察到第五个不生效
		for (int i = 0; i < 5; i++) {
			pool.execute(runnable1);
			pool.execute(runnable2);
		}


		// ----------------------------------------------------------------
		test(pool, start);
		
	}

	public static void test(ExecutorService pool, long start) {
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
