package com.dranawhite.concurrent.serial;

/**
 * @author dranawhite 2017/9/25
 * @version 1.0
 */
public class SerialCounter implements Counter {

    private long range;

    @Override
    public void setRange(long range) {
        this.range = range;
    }

    @Override
    public void count() {
        int a = 0;
        for (int i = 0; i < range; i++) {
            a++;
        }
        int b = 0;
        for (int i = 0; i < range; i++) {
            b--;
        }
    }
}
