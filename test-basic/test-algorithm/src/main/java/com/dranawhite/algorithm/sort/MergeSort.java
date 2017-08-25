package com.dranawhite.algorithm.sort;

/**
 * 归并排序
 * <pre>
 * 算法思想：
 *      将数组不断的分割成一个个极小的单元数组，对每个单元数组排序后，再两两合并
 *
 * 算法复杂度：
 *      O(N*logN)
 * </pre>
 *
 * @author dranawhite 2017/8/25
 * @version 1.0
 */
public class MergeSort extends ComplexSort {

    @Override
    public void sort(Integer[] arrs) {
        merge(arrs, 0, arrs.length - 1);
    }

    private void merge(Integer arrs[], int frist, int last) {
        if (frist == last) {
            return;
        }
        int mid = (frist + last) / 2;
        merge(arrs, frist, mid);
        merge(arrs, mid + 1, last);
        sortArr(arrs, frist, mid + 1, last);
    }

    private void sortArr(Integer arrs[], int frist, int mid, int last) {
        int indexA = frist;
        int indexB = mid;
        int index = 0;
        while (indexA < mid && indexB < last + 1) {
            if (arrs[indexA] < arrs[indexB]) {
                arrs[index++] = arrs[indexA++];
            } else {
                arrs[index++] = arrs[indexB++];
            }
        }
        while (indexB < last + 1) {
            arrs[index++] = arrs[indexB++];
        }
        while (indexA < mid) {
            arrs[index++] = arrs[indexA++];
        }
        for (int i = 0; i < index; i++) {
            arrs[frist + i] = arrs[i];
        }
    }
}
