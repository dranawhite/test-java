package com.dranawhite.concurrent.serial;

import org.junit.Test;


/**
 * @author dranawhite 2017/9/25
 * @version 1.0
 */
public class CounterTest {

    private long range = 500000000L;

    @Test
    public void testSerialCounter() throws InterruptedException {
        System.out.println("====顺序执行====");
        Counter counter = new SerialCounter();
        counter.setRange(range);
        CounterInvocationHandler handler = new CounterInvocationHandler(counter);
        Counter counterProxy = handler.getProxy();
        counterProxy.count();
    }

    @Test
    public void testConcurrencyCounter() throws InterruptedException {
        System.out.println("====并发执行====");
        Counter counter = new ConcurrencyCounter();
        counter.setRange(range);
        CounterInvocationHandler handler = new CounterInvocationHandler(counter);
        Counter counterProxy = handler.getProxy();
        counterProxy.count();
    }

}
