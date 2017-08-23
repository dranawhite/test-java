package com.dranawhite.algorithm.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * @author dranawhite 2017/8/23
 * @version 1.0
 */
public class SortTest {

    private Integer[] arrs;

    @Before
    public void init() {
        arrs = SortUtils.getArray();
    }

    @Test
    public void testBubble() {
        System.out.println("--------冒泡排序--------");
        Sort sort = new BubbleSort();
        sort.sort(arrs);
        SortUtils.printArr(arrs);
    }

}
