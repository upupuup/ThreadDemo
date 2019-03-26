package com.thread;

public class ThreadYieldDemo {
    public static void main(String[] args) {
        Thread thread = new ThreadYield();
        thread.start();
    }
}

class ThreadYield extends Thread {
    @Override
    public void run() {
        long time_start = System.currentTimeMillis();
        for(int i = 0; i < 500; i++) {
            Math.random();
            // Thread.yield();
        }
        long time_end = System.currentTimeMillis();
        System.out.println("用时：" + (time_end - time_start));
    }
}
