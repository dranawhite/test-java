package com.dranawhite.jvm.Concurrent;

/**
 * JVM的线程调度是抢占式优先权调度
 *
 * @author dranawhite 2017/7/21
 * @version 1.0
 */
public class ThreadPriority extends Thread {

    /**
     * 线程名
     */
    private String name;

    public ThreadPriority(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        printLoopIndex(name);
    }

    private void printLoopIndex(String threadName) {
        int index = 0;
        while (index < 100) {
            System.out.println("name: " + threadName + "\t" + index);
            index++;
        }
    }

}
