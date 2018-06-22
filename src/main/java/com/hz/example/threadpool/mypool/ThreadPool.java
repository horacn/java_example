package com.hz.example.threadpool.mypool;


public class ThreadPool {
	
    BlockingQueue<Runnable>  queue;
    public ThreadPool(int queueSize, int nThread) {
        queue = new BlockingQueue<Runnable>(queueSize);
        String threadName = null;
        TaskExecutor task = null;
        for (int count = 0; count < nThread; count++) {
        	threadName = "Thread-"+count;
        	task = new TaskExecutor(queue);
            Thread thread = new Thread(task, threadName);
            thread.start();
        }
    }

    public void submitTask(Runnable task) throws InterruptedException {
        queue.enqueue(task);
    }
}