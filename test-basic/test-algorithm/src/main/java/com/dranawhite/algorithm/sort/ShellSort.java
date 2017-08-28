package com.dranawhite.algorithm.sort;

/**
 * 希尔排序
 * <pre>
 * 算法思想：
 *      希尔排序是在插入排序的基础上实现的，比复杂度为O(N*logN)的排序速度慢，但是优于插入排序，实现简单
 *      希尔排序将数组间隔划为h=3*h+1
 * </pre>
 *
 * @author dranawhite 2017/8/28
 * @version 1.0
 */
public class ShellSort extends ComplexSort {

    @Override
    public void sort(Integer[] arrs) {
        int length = arrs.length;
        int h = 1;
        while (h <= length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = 0; i < length - 1; i++) {
                int j = i;
                if (i + h >= length) {
                    break;
                }
                int temp = arrs[i + h];
                while (j > -1 && arrs[j] >= temp) {
                    arrs[j + h] = arrs[j];
                    j = j - h;
                }
                arrs[j + h] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}
