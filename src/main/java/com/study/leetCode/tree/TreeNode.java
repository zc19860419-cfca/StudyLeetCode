package com.study.leetCode.tree;

/**
 * @Author: zhangchong
 * @Description: Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TreeNode{");
        sb.append("val=").append(val);
        sb.append(", left=").append(null == left ? "null" : left.val);
        sb.append(", right=").append(null == right ? "null" : right.val);
        sb.append('}');
        return sb.toString();
    }
}
