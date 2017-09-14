package com.dranawhite.algorithm.sort;

import java.util.Arrays;

/**
 * Jdk自带排序
 *
 * @author dranawhite 2017/9/14
 * @version 1.0
 */
public class JdkSort implements Sort {

    @Override
    public void sort(Integer[] arrs) {
        Arrays.sort(arrs);
    }
}
