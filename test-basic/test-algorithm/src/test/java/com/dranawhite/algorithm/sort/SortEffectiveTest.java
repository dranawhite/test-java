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
 *      耗时： 18毫秒
 *      --------希尔排序--------
 *      耗时： 50毫秒
 *      --------冒泡排序--------
 *      耗时： 12763毫秒
 *      --------插入排序--------
 *      耗时： 859毫秒
 *      --------选择排序--------
 *      耗时： 2235毫秒
 * </pre>
 *
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
            int data = random.nextInt();
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
}
