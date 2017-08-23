package com.dranawhite.structure.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链表
 * 
 * @author liangyq 2017/8/10
 */
public class LinkedList implements List {
    
    private Node node;
    
    private Node beginMarker;
    
    private Node endMarker;
    
    private int theSize;
    
    private int modCount;
    
    public LinkedList() {
        clear();
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
        beginMarker = new Node(null, null, null);
        endMarker = new Node(null, beginMarker, null);
        beginMarker.previous = endMarker;
        theSize = 0;
        modCount = 0;
    }

    @Override
    public boolean contains(Object data) {
        Node node = beginMarker.next;
        while (node.data != data) {
            node = node.next;
            if (node == endMarker) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean add(Object data) {
        add(theSize, data);
        return true;
    }

    @Override
    public boolean remove(Object data) {
        for (int i = 0; i < theSize; i++) {
            if(get(i) == data) {
                remove(getNode(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        //Todo to be continue ....;
        return null;
    }

    @Override
    public Object get(int idx) {
        return getNode(idx).data;
    }

    @Override
    public void set(int idx, Object data) {
        Node node = getNode(idx);
        node.data = data;
    }

    @Override
    public void add(int idx, Object data) {
        addBefore(getNode(idx), data);
    }

    @Override
    public void remove(int idx) {
        remove(getNode(idx));
    }
    
    private void addBefore(Node node, Object data) {
        Node newNode = new Node<>(data, node.previous, node);
        Node preNode = node.previous;
        preNode.next = newNode;
        theSize++;
        modCount++;
    }
    
    private void remove(Node node) {
        Node preNode = node.previous;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.previous = preNode;
        theSize--;
        modCount++;
    }

    /**
     * 
     * @param idx       索引
     * @param lower     合法的最小索引
     * @param upper     合法的最大索引
     * @return
     */
    private Node getNode(int idx, int lower, int upper) {
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        Node node;
        if (idx  < theSize/2) {
            node = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                node = node.next;
            } 
        } else {
            node = endMarker.previous;
            for (int i = theSize; i > idx; i--) {
                node = node.previous;
            }
        }
        return node; 
    }
    
    private Node getNode(int idx) {
        return getNode(idx, 0, theSize - 1);
    }
    
    private class Node<T> {
        
        public T data;
        
        public Node<T> previous;
        
        public Node<T> next;
        
        public Node(T data, Node<T> p, Node<T> n) {
            this.data = data;
            this.previous = p;
            this.next = n;
        }
    }

    private class LinkedListIterator implements ListIterator {

        private Node curNode = beginMarker.next;

        private int exceptedModCount = modCount;

        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return curNode != endMarker;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (modCount != exceptedModCount) {
                throw new ConcurrentModificationException();
            }
            curNode = curNode.next;
            okToRemove = true;
            return curNode.next.data;
        }

        @Override
        public void remove() {
            if (modCount != exceptedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            LinkedList.this.remove(curNode.previous);
            exceptedModCount++;
            okToRemove = false;
        }

        @Override
        public boolean hasPrevious() {
            //Todo to be continue ....;
            return false;
        }

        @Override
        public Object previous() {
            //Todo to be continue ....;
            return null;
        }

        @Override
        public void add(Object data) {
            //Todo to be continue ....;

        }

        @Override
        public void set(Object data) {
            //Todo to be continue ....;

        }
    }

}
