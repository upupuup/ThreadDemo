package com.thread;

// 守护线程
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread thread = new DaemonThread();
        // 主线程停止Daemon Thread， 线程也停止，但不是立即停止
        thread.setDaemon(true);
        thread.start();
        System.out.println("" + Thread.currentThread().getName() + "停止运行");
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("DaemonThread正在运行！");
        }
    }
}
