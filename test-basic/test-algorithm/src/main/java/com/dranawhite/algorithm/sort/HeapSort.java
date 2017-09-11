package com.dranawhite.algorithm.sort;

/**
 * 堆排序
 * <pre>
 * 算法思想：
 *      二叉树的数组实现，对于某一节点i，它的父节点为(i-1)/2，它的左子节点为2i+1,右子节点为2i+2;
 *      将待排序的序列构造成一个大顶堆。此时，整个序列的最大值就是堆顶的根节点。将它移走（其实就是将其与堆数组
 * 的末尾元素交换，此时末尾元素就是最大值），然后将剩余的 n-1 个序列重新构造成一个堆，这样就会得到 n 个元素中
 * 次大的值。如此反复执行，便能得到一个有序序列了
 *
 * 时间复杂度:
 *      O(N*logN)
 * </pre>
 *
 * @author liangyq 2017/8/30
 */
public class HeapSort extends SelectSort {

    @Override
    public void sort(Integer[] arrs) {
        // 构建一个大顶堆
        for (int i = arrs.length / 2 - 1; i >= 0; i--) {
            buildMaxHeap(arrs, i, arrs.length - 1);
        }
        // 将堆顶最大值放入到数组中，循环构建最大堆
        for (int i = arrs.length - 1; i >= 0; i--) {
            SortUtils.compareAndSwap(arrs, 0, i);
            buildMaxHeap(arrs, 0, i - 1);
        }
    }

    /**
     * 构建最大堆
     *
     * @param arrs
     * @param idx
     * @param len
     */
    private void buildMaxHeap(Integer[] arrs, int idx, int len) {
        int temp = arrs[idx];
        for (int i = 2 * idx; i < len; i = 2 * i) {
            if (arrs[i] < arrs[i + 1]) {
                i = i + 1;
            }
            if (temp >= arrs[i]) {
                break;
            }
            arrs[idx] = arrs[i];
            idx = i;
        }
        arrs[idx] = temp;
    }
}
