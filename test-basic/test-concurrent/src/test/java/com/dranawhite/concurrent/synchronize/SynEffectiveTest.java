package com.dranawhite.concurrent.synchronize;

import com.dranawhite.concurrent.util.TimestampInterceptor;
import org.junit.Test;

/**
 *  ========加锁单线程自增50亿次
 *  耗时：16651ms
 *  ========不加锁自增50亿次
 *  耗时：15879ms
 *
 * @author dranawhite 2017/9/22
 * @version 1.0
 */
public class SynEffectiveTest {

    @Test
    public void testNonSyn() {
        System.out.println("========不加锁自增50亿次");
        TimestampInterceptor interceptor = new TimestampInterceptor();
        SynEffective.Nonsyn nonsyn = interceptor.getProxy(SynEffective.Nonsyn.class);
        nonsyn.run();
    }

    @Test
    public void testSynSingle() {
        System.out.println("========加锁单线程自增50亿次");
        TimestampInterceptor interceptor = new TimestampInterceptor();
        SynEffective.Syn syn = interceptor.getProxy(SynEffective.Syn.class);
        syn.run();
    }

}
