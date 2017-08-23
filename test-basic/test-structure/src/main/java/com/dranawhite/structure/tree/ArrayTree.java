package com.dranawhite.structure.tree;

/**
 * 树数组实现
 *
 * @author dranawhite 2017/8/14
 * @version 1.0
 */
class ArrayTree extends AbstractTree {

    private Object[] objs;
    private int cursor;
    private int size;
    private int height;
    private static final int DEFAULT_HEIGHT = 4;

    public ArrayTree() {
        this.height = DEFAULT_HEIGHT;
        objs = new Object[2^DEFAULT_HEIGHT-1];
        size = 0;
        cursor = 0;
    }

    public ArrayTree(int height) {
        this.height = height;
        objs = new Object[2^height-1];
        size = 0;
        cursor = 0;
    }

    @Override
    public void add(Object data) {
        objs[cursor++] = data;
        size++;
    }

    @Override
    public void remove(Object data) {
        int index = 0;
        for (int i = 0, num = objs.length; i < num; i++) {
            if (data == objs[i]) {
                index = i;
                break;
            }
        }
        if (index == 0) {
            return;
        }
        for (int i = index, num = objs.length; i < num; i++) {
            objs[i] = objs[i+1];
        }
        cursor--;
        size--;
    }

    @Override
    public void clear() {
        for (int i = 0, num = objs.length; i < num; i++) {
            objs[i] = null;
        }
        cursor = 0;
        size = 0;
    }

    @Override
    public void find(Object data) {
        //TODO 遍历数组
    }

    public int size() {
        return this.size;
    }

    private void ensureCapacity() {
        int capacity = 2^height - 1;
        Object[] old = objs;
        objs = new Object[capacity];
        for (int i = 0, num = old.length; i < num; i++) {
            objs[i] = old[i];
        }
    }
}
