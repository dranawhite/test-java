package com.dranawhite.structure.list;

/**
 * 集合接口
 *
 * @author liangyq 2017/8/10
 */
public interface Collection<T> extends Iterable {

    int size();

    boolean isEmpty();

    void clear();

    boolean contains(T data);

    boolean add(T data);

    boolean remove(T data);

    Iterator<T> iterator();

}
