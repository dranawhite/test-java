package com.dranawhite.algorithm.sort;

/**
 * 简单排序
 * <pre>
 * 效率方面：
 *      冒泡排序：过于简单，当数据量很少时会有些应用价值；
 *      选择排序：交换次数最少，当数据量很少，并且交换数据比比较数据更耗时时选用；
 *      插入排序：是这三种中算法最好的选择，适用于数据量比较小或者数据基本有序；
 *
 * 内存方面：
 *      三种算法除了初始数组外，几乎不需要其它内存空间，所有排序算法都需要一个额外的临时变量存储交换时的数据；
 * </pre>
 *
 * @author dranawhite 2017/8/25
 * @version 1.0
 */
public abstract class SimpleSort implements Sort {

}
