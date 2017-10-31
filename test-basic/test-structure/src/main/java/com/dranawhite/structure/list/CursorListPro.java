package com.dranawhite.structure.list;

import org.apache.commons.collections4.list.CursorableLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * CursorableLinkedList研究
 * <pre>
 *     该表可以用于提供在遍历时修改
 * </pre>
 *
 * @author dranawhite 2017/10/30
 * @version 1.0
 */
public class CursorListPro implements ListPro {

    private CursorableLinkedList curList;

    public CursorListPro(List<Integer> list) {
        curList = new CursorableLinkedList(list);
    }

    /**
     * @return the curList
     */
    public CursorableLinkedList getCurList() {
        return curList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(1024);
        for (int i = 0; i <= list.size(); i++) {
            if (i == 1024) {
                System.out.println(list.size());
                break;
            }
            list.add(i);
        }

        CursorListPro listPro = new CursorListPro(list);
        CursorableLinkedList linkedList = listPro.getCurList();
        CursorableLinkedList.Cursor cur = linkedList.cursor();
        while (cur.hasNext()) {
            cur.next();
        }
    }
}
