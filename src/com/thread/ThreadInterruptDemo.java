package com.thread;

// 停止线程的方法，使用interrupt方法
public class ThreadInterruptDemo {
    public static void main(String[] args) {
        Thread thread = new InterruptThread("thread_1");
        thread.start();
        try {
            thread.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName() + "线程设置：interrupt");
        thread.interrupt();
    }
}

class InterruptThread extends Thread {
    public InterruptThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始！");

        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
                System.out.println("" + (i + 1));
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "线程捕获异常，退出循环！");
                e.printStackTrace();
                // 使用break，还以继续打印出下面的语句
                // break;
                // 使用return，就不会打印下面的语句
                return;
            }
        }
        System.out.println(Thread.currentThread().getName() + "线程结束！");
    }
}
