package com.dranawhite.structure.tree;

import java.util.ArrayList;
import java.util.List;

public class BTreeTest 
{
    /** 树根*/
    private BTree root;

    /**
     * 构造函数
     */
    public BTreeTest()
    {
        root = new BTree(new BTree.TreeNode("root", null, ""));
    }

    /**
     * 生成一颗多叉树，根节点为root
     *
     * @param treeNodes 生成多叉树的节点集合
     * @return BTreeTest
     */
    public BTreeTest createTree(List<BTree.TreeNode> treeNodes)
    {
        if(treeNodes == null || treeNodes.size() < 0)
            return null;

        BTreeTest manyNodeTree =  new BTreeTest();

        //将所有节点添加到多叉树中
        for(BTree.TreeNode treeNode : treeNodes)
        {
            if(treeNode.getParentId().equals("root"))
            {
                //向根添加一个节点
                manyNodeTree.getRoot().getChildList().add(new BTree(treeNode));
            }
            else
            {
                addChild(manyNodeTree.getRoot(), treeNode);
            }
        }

        return manyNodeTree;
    }

    /**
     * 向指定多叉树节点添加子节点
     *
     * @param manyTreeNode 多叉树节点
     * @param child 节点
     */
    public void addChild(BTree manyTreeNode, BTree.TreeNode child)
    {
        for(BTree item : manyTreeNode.getChildList())
        {
            if(item.getData().getNodeId().equals(child.getParentId()))
            {
                //找到对应的父亲
                item.getChildList().add(new BTree(child));
                break;
            }
            else
            {
                if(item.getChildList() != null && item.getChildList().size() > 0)
                {
                    addChild(item, child);
                }
            }
        }
    }

    /**
     * 遍历多叉树
     *
     * @param manyTreeNode 多叉树节点
     * @return
     */
    public String iteratorTree(BTree manyTreeNode)
    {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");

        if(manyTreeNode != null)
        {
            for (BTree index : manyTreeNode.getChildList())
            {
                buffer.append(index.getData().getNodeId()+ ",");

                if (index.getChildList() != null && index.getChildList().size() > 0 )
                {
                    buffer.append(iteratorTree(index));
                }
            }
        }

        buffer.append("\n");

        return buffer.toString();
    }

    public BTree getRoot() {
        return root;
    }

    public void setRoot(BTree root) {
        this.root = root;
    }

    public static void main(String[] args)
    {
        List<BTree.TreeNode> treeNodes = new ArrayList<BTree.TreeNode>();
        treeNodes.add(new BTree.TreeNode("系统权限管理", "root", ""));
        treeNodes.add(new BTree.TreeNode("用户管理", "系统权限管理", ""));
        treeNodes.add(new BTree.TreeNode("角色管理", "系统权限管理", ""));
        treeNodes.add(new BTree.TreeNode("组管理", "系统权限管理", ""));
        treeNodes.add(new BTree.TreeNode("用户菜单管理", "系统权限管理", ""));
        treeNodes.add(new BTree.TreeNode("角色菜单管理", "系统权限管理", ""));
        treeNodes.add(new BTree.TreeNode("用户权限管理", "系统权限管理", ""));
        treeNodes.add(new BTree.TreeNode("站内信", "root", ""));
        treeNodes.add(new BTree.TreeNode("写信", "站内信", ""));
        treeNodes.add(new BTree.TreeNode("收信", "站内信", ""));
        treeNodes.add(new BTree.TreeNode("草稿", "站内信", ""));

        BTreeTest tree = new BTreeTest();

        System.out.println(tree.iteratorTree(tree.createTree(treeNodes).getRoot()));
    }

}

