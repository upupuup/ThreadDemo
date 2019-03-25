package com.thread;

/**
 * 第二种现实方法，实现Runnable接口
 */
public class ThreadCreateDemo2 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("通过Runnable接口创建的线程");
    }
}
