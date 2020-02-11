package com.study.leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<TreeNode> children() {
        List<TreeNode> children = new ArrayList<>();
        if (null != left) {
            children.add(left);
        }
        if (null != right) {
            children.add(right);
        }
        return children;
    }

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            TreeNode treeNode = (TreeNode) o;
            result = (val == treeNode.val &&
                    Objects.equals(left, treeNode.left) &&
                    Objects.equals(right, treeNode.right));
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
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
