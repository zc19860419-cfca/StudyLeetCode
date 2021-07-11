package com.study.leetCode.tree.bfs;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * @Author: zhangchong
 * @Description:
 */
public class IsSymmetricSolution101 {
    public boolean isSymmetric1(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode u, TreeNode v) {
        boolean isSymmetric = true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);

        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null || v.val != u.val) {
                isSymmetric = false;
                break;
            }
            q.offer(u.left);
            q.offer(v.right);
            q.offer(u.right);
            q.offer(v.left);
        }
        return isSymmetric;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        //two pointer technic on two subtree
        return preorder(root.left, root.right);
    }

    boolean preorder(TreeNode left, TreeNode right) {
        //case 1 both left == null && right == null return true
        //case 2 left == null && right != null or left != null && right == null return false
        //case 3 left != right return false
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        // if ((left == null && right != null) || (left != null && right == null)) return false;
        if (left.val != right.val) {
            return false;
        }

        boolean t1 = preorder(left.left, right.right);
        boolean t2 = preorder(left.right, right.left);
        return t1 && t2;
    }

    public static class TreeNode {
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

        @Override
        public String toString() {
            return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("left=" + (left == null ? "null" : left.val))
                    .add("right=" + (right == null ? "null" : right.val))
                    .toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TreeNode treeNode = (TreeNode) o;

            if (val != treeNode.val) return false;
            if (!Objects.equals(left, treeNode.left)) return false;
            return Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }
    }
}
