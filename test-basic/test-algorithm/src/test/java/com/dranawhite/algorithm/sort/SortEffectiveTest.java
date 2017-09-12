package com.dranawhite.algorithm.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 排序效率测试
 * <pre>
 * 随机生成5万数据，效率测试结果
 *      --------归并排序--------
 *      耗时： 50毫秒
 *      --------快速排序--------
 *      耗时： 25毫秒
 *      --------希尔排序--------
 *      耗时： 28毫秒
 *      --------冒泡排序--------
 *      耗时： 16826毫秒
 *      --------插入排序--------
 *      耗时： 1037毫秒
 *      --------选择排序--------
 *      耗时： 2761毫秒
 *      --------堆排序--------
 *      耗时： 29毫秒
 *      --------基数排序--------
 *      耗时： 37毫秒
 * </pre>
 * @author dranawhite 2017/8/28
 * @version 1.0
 */
public class SortEffectiveTest {

    private Integer[] arrs;

    @Before
    public void init() {
        int num = 50000;
        List<Integer> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            Random random = new Random();
            int data = random.nextInt(Integer.MAX_VALUE);
            list.add(data);
        }
        arrs = list.toArray(new Integer[]{});
    }

    @Test
    public void testInsert() {
        System.out.println("--------插入排序--------");
        SortPerformProxy sortPerformProxy = new SortPerformProxy(new InsertSort());
        Sort sort = sortPerformProxy.getSort();
        sort.sort(arrs);
    }

    @Test
    public void testSelect() {
        System.out.println("--------选择排序--------");
        SortPerformProxy sortPerformProxy = new SortPerformProxy(new SelectSort());
        Sort sort = sortPerformProxy.getSort();
        sort.sort(arrs);
    }

    @Test
    public void testMerge() {
        System.out.println("--------归并排序--------");
        SortPerformProxy sortPerformProxy = new SortPerformProxy(new MergeSort());
        Sort sort = sortPerformProxy.getSort();
        sort.sort(arrs);
    }

    @Test
    public void testBubble() {
        System.out.println("--------冒泡排序--------");
        SortPerformProxy sortPerformProxy = new SortPerformProxy(new BubbleSort());
        Sort sort = sortPerformProxy.getSort();
        sort.sort(arrs);
    }

    @Test
    public void testShell() {
        System.out.println("--------希尔排序--------");
        SortPerformProxy sortPerformProxy = new SortPerformProxy(new ShellSort());
        Sort sort = sortPerformProxy.getSort();
        sort.sort(arrs);
    }

    @Test
    public void testQuick() {
        System.out.println("--------快速排序--------");
        SortPerformProxy sortPerformProxy = new SortPerformProxy(new QuickSort());
        Sort sort = sortPerformProxy.getSort();
        sort.sort(arrs);
    }

    @Test
    public void testHeap() {
        System.out.println("--------堆排序--------");
        SortPerformProxy sortPerformProxy = new SortPerformProxy(new HeapSort());
        Sort sort = sortPerformProxy.getSort();
        sort.sort(arrs);
    }

    @Test
    public void testRadix() {
        System.out.println("--------基数排序--------");
        SortPerformProxy sortPerformProxy = new SortPerformProxy(new RadixSort());
        Sort sort = sortPerformProxy.getSort();
        sort.sort(arrs);
    }
}
