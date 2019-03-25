package com.thread;

public class ThreadShareVariableDemo {
    public static void main(String[] args) {
        Runnable runnable = new ShareVariableRunnable();
        Thread[] threads = new Thread[10];

        for(int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable ,"thread:" + (i + 1));
        }

        for(Thread threadItem : threads) {
            threadItem.start();
        }
    }
}

class ShareVariableRunnable implements Runnable {
    private int count = 10;

    // 看出多线程对同一变量进行读写操作不同步产生的
//    @Override
//    public void run() {
//        System.out.println("" + Thread.currentThread().getName() + ",count:" + count--);
//    }

    // 添加synchronized关键字给count加锁

    @Override
    public synchronized void run() {
        System.out.println("" + Thread.currentThread().getName() + ",count:" + count--);
    }
}
