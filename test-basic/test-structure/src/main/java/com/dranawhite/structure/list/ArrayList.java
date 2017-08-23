package com.dranawhite.structure.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/**
 * 表
 * 
 * @author liangyq 2017/8/10
 */
class ArrayList<T> implements List, RandomAccess {

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;

    private Object[] theItems;

    public ArrayList() {
        theItems = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        theItems = new Object[capacity];
    }

    @Override
    public int size() {
        return theSize;
    }

    @Override
    public boolean isEmpty() {
        return theSize == 0;
    }

    @Override
    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    @Override
    public boolean contains(Object data) {
        for (int i = 0; i < theSize; i++) {
            if (data == theItems[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Object data) {
        add(theSize, data);
        return true;
    }

    @Override
    public boolean remove(Object data) {
        for (int i = 0; i < theSize; i++) {
            if (data == theItems[i]) {
                remove(i);
                break;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int idx) {
        if (idx < 0 || idx > theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) theItems[idx];
    }

    @Override
    public void set(int idx, Object data) {
        if (idx < 0 || idx > theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        theItems[idx] = data;
    }

    @Override
    public void add(int idx, Object data) {
        if (idx < 0 || idx > theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (theSize == theItems.length) {
            ensureCapacity(theSize*2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i-1];
        }
        theItems[idx] = data;
        theSize++;
    }

    @Override
    public void remove(int idx) {
        for (int i = idx; i < theSize; i++) {
            theItems[i] = theItems[i+1];
        }
        theSize--;
    }
    
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        Object[] oldItems = theItems;
        theItems = new Object[newCapacity];
        for (int i = 0; i < theSize; i++) {
            theItems[i] = oldItems[i];
        }
    }
    
    public void trimToSize() {
        ensureCapacity(theSize);
    }

    public T[] toArray(T[] e) {
        return (T[])Arrays.copyOf(theItems, theSize, e.getClass());
    }

    @Override
    public String toString() {
        StringBuilder arrSb = new StringBuilder();
        arrSb.append("[");
        for (int i = 0 ; i < theSize; i++) {
            arrSb.append(theItems[i] + ",");
        }
        arrSb.deleteCharAt(arrSb.length() - 1);
        arrSb.append("]");
        return arrSb.toString();
    }
    
    private class ArrayListIterator<T> implements ListIterator {

        private int current;
        
        @Override
        public boolean hasNext() {
            return current < theSize - 1;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) theItems[current++];
        }

        @Override
        public void remove() {
            ArrayList.this.remove(current);
            current--;
        }

        @Override
        public boolean hasPrevious() {
            if (current > 0 && theSize > 0) {
                return true;
            }
            return false;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            return (T) theItems[current--];
        }

        @Override
        public void add(Object data) {
            ArrayList.this.add(current, data);
        }

        @Override
        public void set(Object data) {
            theItems[current] = data;
        }
    }
}
