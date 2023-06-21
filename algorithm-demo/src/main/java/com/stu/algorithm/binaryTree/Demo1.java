package com.stu.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * @Author wangyixing
 * @Description 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 */
public class Demo1 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<Integer>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        List<TreeNode> rootList = new ArrayList<TreeNode>();
        dfs(root, true, toDeleteSet, rootList);
        return rootList;
    }

    /**
     * 深度优先搜索
     * 时间复杂度：O(n)其中n是树的节点数
     * 空间复杂度：O(n)其中n是树的节点数
     */
    public TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> toDeleteSet, List<TreeNode> rootList) {
        if (node == null) {
            return null;
        }
        boolean deleteVal = toDeleteSet.contains(node.val);
        node.left = dfs(node.left, deleteVal, toDeleteSet, rootList);
        node.right = dfs(node.right, deleteVal, toDeleteSet, rootList);
        if (deleteVal) {
            return null;
        }
        if (isRoot) {
            rootList.add(node);
        }
        return node;
    }

    /**
     * 输入 [1,2,3,4,5,6,7] 删除 [3,5] 输出 [[6],[7],[1,2,null,4]]
     * 输入 [1,2,4,null,3]  删除 [3]   输出 [[1,2,4]]
     *
     * @param args
     */
    public static void main(String[] args) {
    }
}
