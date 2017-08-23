package com.dranawhite.algorithm.sort;

import org.junit.Test;

/**
 * @author dranawhite 2017/8/23
 * @version 1.0
 */
public class SortUtilsTest {

    @Test
    public void testShuffle() {
        System.out.println("--------初始化数组--------");
        Integer[] arr = SortUtils.getArray();
        SortUtils.printArr(arr);
    }

    @Test
    public void testSwap() {
        System.out.println("--------交换数字位置------");
        Integer[] arr = SortUtils.getArray();
        SortUtils.compareAndSwap(arr, 3, 4);
        SortUtils.printArr(arr);
    }

}
