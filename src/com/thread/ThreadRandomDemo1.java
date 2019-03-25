package com.thread;

public class ThreadRandomDemo1 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for(int i = 0; i < 10; i++) {
            threads[i] = new RandomThread("RandomThread:" + i);
        }

        // 打印结果不按照顺序，因为线程调度是由cpu决定的，cpu执行子任务具有不确定性
        for(Thread threadItem : threads) {
            threadItem.start();
        }
    }
}

class RandomThread extends Thread {
    public RandomThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}