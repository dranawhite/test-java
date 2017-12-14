package com.dranawhite.structure.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 表遍历
 *
 * @author dranawhite 2017/12/8
 * @version 1.0
 */
public class ListIteratorPro {

    private static List<Integer> list;

    static {
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
    }

    public void listRemove() {
        for (int i = 0, len = list.size(); i < len; i++) {
            list.get(i);
            if (i == 5) {
                list.remove(i);
            }
        }
    }
}
