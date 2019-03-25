package com.thread;

/**
 * 第一种实现方法，继承Thread类
 */
public class ThreadCreateDemo1 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("通过继承Thread类创建线程");
    }
}
