package com.hz.example.langproblem;

/**
 * 编程之美，JAVA控制CPU的使用率(2),完美曲线
 *
 * @author 赵学庆，Java世纪网(java2000.net)
 */
public class ControlCPU {

    // 1
//    public static void main(String[] args) throws Exception {
//        // 角度的分割
//        final double SPLIT = 0.01;
//        //
//        // 2PI分割的次数，也就是2/0.01个，正好是一周
//        final int COUNT = (int) (2 / SPLIT);
//        final double PI = Math.PI;
//        // 时间间隔
//        final int INTERVAL = 200;
//        long[] busySpan = new long[COUNT];
//        long[] idleSpan = new long[COUNT];
//        int half = INTERVAL / 2;
//        double radian = 0.0;
//        for (int i = 0; i < COUNT; i++) {
//            busySpan[i] = (long) (half + (Math.sin(PI * radian) * half));
//            idleSpan[i] = INTERVAL - busySpan[i];
//            radian += SPLIT;
//        }
//        long startTime = 0;
//        int j = 0;
//        while (true) {
//            j = j % COUNT;
//            startTime = System.currentTimeMillis();
//            while (System.currentTimeMillis() - startTime < busySpan[j])
//                ;
//            Thread.sleep(idleSpan[j]);
//            j++;
//        }
//    }


    // 2
    public static void main(String[] args) {
        int busyTime = 10;
        int idleTime = busyTime;
        long startTime;
        while (true) {
            startTime = System.currentTimeMillis(); // busy loop
            while ((System.currentTimeMillis() - startTime) <= busyTime) ; // idle
            // loop
            try {
                Thread.sleep(idleTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}