package com.dranawhite.jvm.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dranawhite 2017/8/11
 * @version 1.0
 */
public class ForEach {

    private static ArrayList<Integer> strList = new ArrayList<>(50);

    static {
        strList.add(0);
        strList.add(1);
        strList.add(2);
        strList.add(3);
        strList.add(4);
        strList.add(5);
        strList.add(6);
        strList.add(7);
        strList.add(8);
        strList.add(9);
        strList.add(10);
        strList.add(11);
        strList.add(12);
        strList.add(13);
        strList.add(14);
        strList.add(15);
        strList.add(16);
        strList.add(17);
        strList.add(18);
        strList.add(19);
        strList.trimToSize();
    }

    public static List<Integer> getList() {
        return strList;
    }

    public static Integer[] getArray() {
        return strList.toArray(new Integer[20]);
    }

}