package com.dranawhite.structure.list;

import java.util.Iterator;

/**
 * 表接口
 *
 * @author liangyq 2017/8/10
 */
interface List<E> extends Collection<E> {

    E get(int idx);

    void set(int idx, E data);

    void add(int idx, E data);

    void remove(int idx);


    interface ListIterator<E> extends Iterator<E> {

        boolean hasPrevious();

        E previous();

        void add(E data);

        void set(E data);

    }

}
