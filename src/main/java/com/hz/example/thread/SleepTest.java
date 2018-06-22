package com.hz.example.thread;
import java.util.Date;
/**
 * sleep()指在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）。
 * @author Administrator
 *
 */
public class SleepTest {
    public static void main(String[] args) {

    	for (int i = 0; i < 100; i++) {
    		Thread2 t = new Thread2();
    		//t.run(); //这里也不能直接调用方法
    		t.start();
		}
    	
        try {
            Thread.sleep(5000); //主线程睡眠10秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //主线程睡眠10秒钟后结束t线程
        //t.interrupt(); //这种结束方式比较粗暴，如果t线程打开了某个资源还没来得及关闭也就是run方法还没有执行完就强制结束线程，会导致资源无法关闭
        //t.stop();也是结束某个线程，这种方式比interrupt()更粗暴
        Thread2.flag = false;
    }
}
class Thread2 extends Thread{
    
	static volatile boolean flag = true; //用这种方式结束线程很不错，用一个变量控制run方法什么时候不再执行，不会出现run方法没有执行完毕就结束
	
    @Override
    public void run() { //run方法一结束，整个线程就终止了
        if(flag){
            System.out.println("---"+new Date()+"---");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}