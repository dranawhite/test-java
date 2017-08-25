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

    @Test
    public void testInsert() {
        System.out.println("--------插入排序--------");
        Sort sort = new InsertSort();
        sort.sort(arrs);
        SortUtils.printArr(arrs);
    }

    @Test
    public void testSelect() {
        System.out.println("--------选择排序--------");
        Sort sort = new SelectSort();
        sort.sort(arrs);
        SortUtils.printArr(arrs);
    }

    @Test
    public void testMerge() {
        System.out.println("--------归并排序--------");
        Sort sort = new MergeSort();
        sort.sort(arrs);
        SortUtils.printArr(arrs);
    }

}
