package com.dranawhite.jvm.assertion;

import org.junit.Test;

/**
 * @author dranawhite 2017/8/4
 * @version 1.0
 */
class AssertTest {

    @Test
    public void testSucc() {
        Assert.assertSucc();
    }

    @Test(expected = java.lang.AssertionError.class)
    public void testFail() {
        Assert.assertFail();
    }
}
