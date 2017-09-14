package com.dranawhite.algorithm.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

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

    @Test
    public void testShell() {
        System.out.println("--------希尔排序--------");
        Sort sort = new ShellSort();
        sort.sort(arrs);
        SortUtils.printArr(arrs);
    }

    @Test
    public void testQuick() {
        System.out.println("--------快速排序--------");
        Sort sort = new QuickSort();
        sort.sort(arrs);
        SortUtils.printArr(arrs);
    }

    @Test
    public void testHeap() {
        System.out.println("--------堆排序--------");
        Sort sort = new HeapSort();
        sort.sort(arrs);
        SortUtils.printArr(arrs);
    }

    @Test
    public void testRadix() {
        System.out.println("--------基数排序--------");
        Sort sort = new RadixSort();
        sort.sort(arrs);
        SortUtils.printArr(arrs);
    }

    @Test
    public void testBucket() {
        System.out.println("--------桶排序--------");
        Sort sort = new BucketSort();
        sort.sort(arrs);
        SortUtils.printArr(arrs);
    }

    @Test
    public void testJdk() {
        System.out.println("--------JDK排序--------");
        Sort sort = new JdkSort();
        sort.sort(arrs);
        SortUtils.printArr(arrs);
    }
}
