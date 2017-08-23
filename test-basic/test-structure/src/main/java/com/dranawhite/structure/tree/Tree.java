package com.dranawhite.structure.tree;

/**
 * 树接口
 *
 * @author dranawhite 2017/8/14
 * @version 1.0
 */
interface Tree<T> {

    void add(T data);

    void remove(T data);

    void clear();

    void find(T data);

}
