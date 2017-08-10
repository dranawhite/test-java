package com.dranawhite.structure.list;

/**
 * 迭代器接口
 *
 * @author liangyq 2017/8/10
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();

    void remove();

}
