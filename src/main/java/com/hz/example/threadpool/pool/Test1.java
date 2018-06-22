package com.hz.example.threadpool.pool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import com.hz.example.threadpool.pool.guava.MyAbstractIdleService;

public class Test1 {
	public static void main(String[] args) {
//		List< Thread> list = new ArrayList<>();
//		
//		for (int i = 0; i < 100; i++) {
//			Thread t = new MyThread();
//			list.add(t);
//		}
//		
//		for (int i = 0; i < list.size(); i++) {
//			list.get(i).start();
//		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
		long start = System.currentTimeMillis();
		
		//[3924586] 为您报时，现在是北京时间:2017-04-28 14:48:19:95
		//单线程
//		while (true) {
//			String now = sdf.format(new Date());
//			System.out.println("["+(++count)+"] 为您报时，现在是北京时间:" + now);
//			long end = System.currentTimeMillis();
//			if(end - start > 30000L){
//				break;
//			}
//		}
		
		
		//[501517] 为您报时，现在是北京时间:2017-04-28 14:38:19:624
		//Thread
//		while (true) {
//			++count;
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					String now = sdf.format(new Date());
//					System.out.println("["+count+"] 为您报时，现在是北京时间:" + now);
//				}
//			}).start();
//			long end = System.currentTimeMillis();
//			if(end - start > 30000L){
//				break;
//			}
//		}
		
		
		//[1242083] 为您报时，现在是北京时间:2017-04-28 14:42:22:756
//		ExecutorService pool = Executors.newCachedThreadPool();
//		while (true) {
//			++count;
//			//线程池 添加线程
//			pool.execute(new Runnable() {
//				@Override
//				public void run() {
//					String now = sdf.format(new Date());
//					System.out.println("["+count+"] 为您报时，现在是北京时间:" + now);
//				}
//			});
//			long end = System.currentTimeMillis();
//			if(end - start > 30000L){
//				break;
//			}
//		}
//		pool.shutdownNow();
		
		
		   
		//[6565231] 为您报时，现在是北京时间:2017-04-28 14:46:12:133
//		ExecutorService pool = Executors.newFixedThreadPool(4);
//		while (true) {
//			++count;
//			//线程池 添加线程
//			pool.execute(new Thread(new Runnable() {
//				@Override
//				public void run() {
//					String now = sdf.format(new Date());
//					System.out.println("["+count+"] 为您报时，现在是北京时间:" + now);
//				}
//			}));
//			long end = System.currentTimeMillis();
//			if(end - start > 30000L){
//				break;
//			}
//		}
//		pool.shutdownNow();
		
		
		//[6424189] 为您报时，现在是北京时间:2017-04-28 14:50:00:578
//		ExecutorService pool = Executors.newSingleThreadExecutor();
//		while (true) {
//			++count;
//			//线程池 添加线程
//			pool.execute(new Thread(new Runnable() {
//				@Override
//				public void run() {
//					String now = sdf.format(new Date());
//					System.out.println("["+count+"] 为您报时，现在是北京时间:" + now);
//				}
//			}));
//			long end = System.currentTimeMillis();
//			if(end - start > 30000L){
//				break;
//			}
//		}
//		pool.shutdownNow();
		
		
		//[1945529] 为您报时，现在是北京时间:2017-04-28 15:01:52:446
//        ThreadPool threadPool = new ThreadPool(4,6);
//        while(true){
//			//线程池 添加线程
//			try {
//				threadPool.submitTask(new Thread(new Runnable() {
//					@Override
//					public void run() {
//						++count;
//						String now = sdf.format(new Date());
//						System.out.println("["+count+"] 为您报时，现在是北京时间:" + now);
//					}
//				}));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			long end = System.currentTimeMillis();
//			if(end - start > 30000L){
//				break;
//			}
//        }
        
        
        //[6301618] 为您报时，现在是北京时间:2017-04-28 15:06:38:607
//		BlockingQueue<Runnable> queue =  new TaskQueue();
//		ExecutorService pool = new ThreadPoolExecutor(2, 5, 3, TimeUnit.MINUTES, queue);
//		while (true) {
//			++count;
//			//线程池 添加线程
//			pool.execute(new Thread(new Runnable() {
//				@Override
//				public void run() {
//					String now = sdf.format(new Date());
//					System.out.println("["+count+"] 为您报时，现在是北京时间:" + now);
//				}
//			}));
//			long end = System.currentTimeMillis();
//			if(end - start > 30000L){
//				break;
//			}
//		}
//		pool.shutdownNow();
        
		
	 //[1837381] 为您报时，现在是北京时间:2017-04-28 15:15:23:724
//      while(true){
//			//线程池 添加线程
//			try {
//				Job job = new Job("xx") {
//					@Override
//					protected IStatus run(IProgressMonitor monitor) {
//						monitor.beginTask("Job 1", 60000);
//						
//						++count;
//						String now = sdf.format(new Date());
//						System.out.println("["+count+"] 为您报时，现在是北京时间:" + now);
//						long end = System.currentTimeMillis();
//						if(end - start > 30000L){
//							System.exit(1);
//						}
//						
//						monitor.worked(1);
//						monitor.done();
//						return Status.OK_STATUS;
//					}
//				};  
//				job.schedule();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//      }
		
		
		//guava
//		ArrayList<Object> list = Lists.newArrayList(1,2,3);
//		for (Object l : list) {
//			System.out.println(l);
//		}
		
		
		ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(4)); 
		ListenableFuture<String> future = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());   
	            //一个模拟耗时的操作  
	            for (int i = 999999; i > 0; i--) ;   
	            
//	            int i = 0;
//	            if(1/i > 1){
//	            	
//	            }
	            
	            return "call()方法被自动调用，任务的结果是：" + 1 + "    " + Thread.currentThread().getName();   
			}
		});
		
		try {
			System.out.println(future.get());
			
			Futures.addCallback(future, new FutureCallback() {
				@Override
				public void onSuccess(Object paramV) {
					System.out.println("成功");
				}
				@Override
				public void onFailure(Throwable paramThrowable) {
					System.out.println("失败");
				}
			});
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		service.shutdown();
		
		
		List list = new ArrayList();
		Service s = new MyAbstractIdleService();
		s.startAsync();
		list.add(s);
		ServiceManager serviceManager = new ServiceManager(list);
		serviceManager.stopAsync();
		
	}
	
	static int count = 0;
	
}
