package com.dranawhite.jvm.generation;

/**
 * @author dranawhite 2017/8/23
 * @version 1.0
 */
class Basic<E> {

    private E e;

    public Basic(E e) {
        this.e = e;
    }

    public void set(E e) {
        this.e = e;
    }

    public E get() {
        return this.e;
    }

}
