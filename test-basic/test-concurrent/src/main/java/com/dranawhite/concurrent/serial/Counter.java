package com.dranawhite.concurrent.serial;

/**
 * @author dranawhite 2017/9/25
 * @version 1.0
 */
public interface Counter {

    void setRange(long range);

    void count() throws InterruptedException;

}
