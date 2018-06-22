package com.hz.example.threadpool.mypool;


public class TaskExecutor implements Runnable {
    BlockingQueue<Runnable> queue;
    
    public TaskExecutor(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
//                String name = Thread.currentThread().getName();
                Runnable task = queue.dequeue();
//                System.out.println("Task Started by Thread :" + name);
                task.run();
//                System.out.println("Task Finished by Thread :" + name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}