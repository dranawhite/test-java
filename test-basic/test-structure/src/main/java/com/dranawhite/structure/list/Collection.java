package com.dranawhite.structure.list;

import java.util.Iterator;

/**
 * 集合接口
 *
 * @author liangyq 2017/8/10
 */
interface Collection<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    void clear();

    boolean contains(T data);

    boolean add(T data);

    boolean remove(T data);

    Iterator<T> iterator();

}
