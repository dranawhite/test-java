package com.dranawhite.algorithm.sort;

/**
 * 堆排序
 * <pre>
 * 算法思想：
 *      二叉树的数组实现，对于某一节点i，它的父节点为(i-1)/2，它的左子节点为2i+1,右子节点为2i+2
 *
 * 时间复杂度:
 *      O(N*logN)
 * </pre>
 *
 * @author liangyq 2017/8/30
 */
public class HeapSort extends ComplexSort {

    @Override
    public void sort(Integer[] arrs) {
        for (int i = 0, len = arrs.length; i < len - 1; i++) {
            buildMaxHeap(arrs, len - 1 - i);
            SortUtils.compareAndSwap(arrs, 0, len - 1 - i);
        }
    }

    private void buildMaxHeap(Integer[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            while (k * 2 + 1 <= lastIndex) {
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }
                if (data[k] < data[biggerIndex]) {
                    SortUtils.compareAndSwap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }
}
