package com.thread;

// 停止线程的方法，使用退出标志
public class ThreadVariableStopDemo {
    public static void main(String[] args) {
        VariableStopThread thread = new VariableStopThread("thread_1");
        thread.start();
        try {
            thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 停止之后可能还会有打印出数据，是因为while方法体中的是原子操作，不能被直接打断
        thread.stopThread();
    }

}

class VariableStopThread extends Thread {
    private Boolean interrupt = true;

    public VariableStopThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始运行");
        int i = 0;
        while(interrupt) {
            System.out.println("" + i++);
        }
        System.out.println("我停止了线程！timer：" +   System.currentTimeMillis());
    }

    public void stopThread() {
        System.out.println(Thread.currentThread() + "：线程设置了停止！timer：" + System.currentTimeMillis());
        this.interrupt = false;
    }
}
