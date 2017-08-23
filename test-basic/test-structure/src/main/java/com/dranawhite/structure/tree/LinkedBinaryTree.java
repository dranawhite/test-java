package com.dranawhite.structure.tree;

/**
 * 树链表实现
 *
 * @author dranawhite 2017/8/14
 * @version 1.0
 */
class LinkedBinaryTree extends AbstractTree implements BinaryTree {

    @Override
    public void add(Object data) {

    }

    @Override
    public void remove(Object data) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void find(Object data) {

    }

    private class Node {

        private Object data;
        private Node left;
        private Node right;

        public Node(Object data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }


    }

}
