package com.dranawhite.concurrent.serial;

/**
 * @author dranawhite 2017/9/25
 * @version 1.0
 */
public class ConcurrencyCounter implements Counter {

    private long range;

    @Override
    public void setRange(long range) {
        this.range = range;
    }

    @Override
    public void count() throws InterruptedException {

        Thread t = new Thread() {
            int a = 0;
            @Override
            public void run() {
                for (int i = 0; i < range; i++) {
                    a++;
                }
            }
        };
        t.setName("CountA");
        t.start();
        int b = 0;
        for (int i = 0 ; i < range; i++) {
            b--;
        }
        Thread.currentThread().setName("CountB");
    }
}
