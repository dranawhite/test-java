package com.dranawhite.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * B树
 *
 * @author liangyq 2017/8/14
 */
class BTree {

    /**
     * 树节点
     */
    private TreeNode data;

    /**
     * 子树集合
     */
    private List<BTree> childList;

    /**
     * 构造函数
     *
     * @param data 树节点
     */
    public BTree(TreeNode data) {
        this.data = data;
        this.childList = new ArrayList<>();
    }

    /**
     * 构造函数
     *
     * @param data      树节点
     * @param childList 子树集合
     */
    public BTree(TreeNode data, List<BTree> childList) {
        this.data = data;
        this.childList = childList;
    }

    public TreeNode getData() {
        return data;
    }

    public void setData(TreeNode data) {
        this.data = data;
    }

    public List<BTree> getChildList() {
        return childList;
    }

    public void setChildList(List<BTree> childList) {
        this.childList = childList;
    }

    static class TreeNode {

        /**
         * 节点Id
         */
        private String nodeId;

        /**
         * 父节点Id
         */
        private String parentId;

        /**
         * 文本内容
         */
        private String text;

        /**
         * 构造函数
         *
         * @param nodeId   节点Id
         * @param parentId 父节点Id
         */
        public TreeNode(String nodeId, String parentId, String text) {
            this.nodeId = nodeId;
            this.parentId = parentId;
            this.text = text;
        }

        public String getText() {
            return this.text;
        }

        public String getNodeId() {
            return nodeId;
        }

        public String getParentId() {
            return parentId;
        }
    }
}
