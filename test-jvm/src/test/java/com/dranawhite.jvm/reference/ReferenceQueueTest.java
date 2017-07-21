package com.dranawhite.jvm.reference;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author dranawhite 2017/7/21
 * @version 1.0
 */
public class ReferenceQueueTest {

    @Test
    public void testGC() {
        final ReferenceQueue referenceQueue = new ReferenceQueue();
        String str = new String("AK47");
        WeakReference wr = new WeakReference(str, referenceQueue);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Reference reference = referenceQueue.remove();
                    System.out.println(reference + " event fired.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setDaemon(true);
        t.start();
        System.out.println("Reference Queue is listening.");
        str = null; // clear strong reference
        System.out.println("Ready to gc");
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wr.get: " + wr.get());
    }
}
