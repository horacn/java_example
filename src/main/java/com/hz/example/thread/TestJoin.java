package com.hz.example.thread;

import java.util.Date;

/*
 * t.join()方法指等待t线程终止。也可以理解为将t线程合并到当前线程来，等待t线程结束后再往下执行。相当于方法调用
 */
public class TestJoin {
    public static void main(String[] args) {
        Thread t = new Thread3("abc");
        t.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("我是main线程");
            if(i==10){
                try {
                    t.join();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread3 extends Thread{
    public Thread3(String s) { //给该线程取一个名字，用getName()方法可以去到该名字
        super(s);
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我是"+getName()+"线程");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}