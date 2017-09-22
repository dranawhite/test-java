package com.dranawhite.concurrent.synchronize;

/**
 * 测试加锁和不加锁时效率问题
 *
 * @author dranawhite 2017/9/22
 * @version 1.0
 */
public class SynEffective {

    public static class Nonsyn{
        Long num = 5000000000L;

        public void run() {
            while (num > 0) {
                num--;
            }
        }
    }

    public static class Syn {
        Long num = 5000000000L;

        public void run() {
            synchronized (num) {
                while ( num > 0) {
                    num--;
                }
            }
        }

    }

}
