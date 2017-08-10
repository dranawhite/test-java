package com.dranawhite.structure.tree;

/**
 * @author liangyq 2017/8/10
 */
public class BinarySearchTree implements Comparable {

    @Override
    public int compareTo(Object obj) {
        //Todo to be continue ....;
        return 0;
    }

    private boolean contains(Object data, BinaryNode node) {
        //TODO
        return false;
    }

    private class BinaryNode {

        public Object data;

        public BinaryNode left;

        public BinaryNode right;

        public BinaryNode(Object data) {
            this(data, null, null);
        }

        public BinaryNode(Object data, BinaryNode left, BinaryNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
}
