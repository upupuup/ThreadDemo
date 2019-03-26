package com.thread;

// 线程优先级
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        Thread thread_1 = new ThreadPriority("thread_1<<<");
        Thread thread_2 = new ThreadPriority("thread_2<<<");
        // 取消优先级的话，thread_2，那么会继承main函数的优先级
        // thread_2.setPriority(Thread.MIN_PRIORITY);
        thread_1.setPriority(Thread.MAX_PRIORITY);

        // 1、调度顺序不一样，具有随机性，和优先级没有关系
        // 2、运行顺序与代码的顺序不一致
        thread_2.start();
        thread_1.start();
    }
}

class ThreadPriority extends Thread {
    public ThreadPriority(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("" + Thread.currentThread().getName() + ", number:" + i + ", Priority:" + Thread.currentThread().getPriority());
        }
    }
}
