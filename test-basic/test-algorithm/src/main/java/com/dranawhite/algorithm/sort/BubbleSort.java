package com.dranawhite.algorithm.sort;

/**
 * 冒泡排序
 * <pre>
 * 算法思想：
 *     从左向右依次比较相邻的两个数字A和B，如果A大于B则交换位置，否则则不动；
 *     继续比较下两组数字；
 * </pre>
 *
 * @author dranawhite 2017/8/23
 * @version 1.0
 */
public class BubbleSort implements Sort {

    public void sort(Integer[] arrs) {
        for (int j = arrs.length; j > 2; j--) {
            for (int i = 1; i < j; i++) {
                SortUtils.compareAndSwap(arrs, i - 1, i);
            }
        }
    }

}
