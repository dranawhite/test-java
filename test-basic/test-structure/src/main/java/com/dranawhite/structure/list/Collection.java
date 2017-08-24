package com.dranawhite.structure.list;

import java.util.Iterator;

/**
 * 集合接口
 *
 * @author liangyq 2017/8/10
 */
interface Collection<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    void clear();

    boolean contains(E data);

    boolean add(E data);

    boolean remove(E data);

    Iterator<E> iterator();

}
