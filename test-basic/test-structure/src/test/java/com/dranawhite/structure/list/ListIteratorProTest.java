package com.dranawhite.structure.list;

import org.junit.Test;

/**
 * @author dranawhite 2017/12/8
 * @version 1.0
 */
public class ListIteratorProTest {

    private ListIteratorPro pro = new ListIteratorPro();

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListRemove() {
        pro.listRemove();
    }

}
