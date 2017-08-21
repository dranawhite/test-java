package com.dranawhite.structure.list;

/**
 * 表接口
 *
 * @author liangyq 2017/8/10
 */
public interface List<T> extends Collection {

    T get(int idx);

    void set(int idx, T data);

    void add(int idx, T data);

    void remove(int idx);


    interface ListIterator<T> extends Iterator {

        boolean hasPrevious();

        T previous();

        void add(T data);

        void set(T data);

    }

}
