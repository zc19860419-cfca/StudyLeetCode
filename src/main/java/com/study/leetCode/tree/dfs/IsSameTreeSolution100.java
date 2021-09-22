package com.study.leetCode.tree.dfs;

import com.study.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class IsSameTreeSolution100 {
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        List<Integer> inorder1 = visitInOrder(p);
//        System.out.println(inorder1);
        List<Integer> inorder2 = visitInOrder(q);
//        System.out.println(inorder2);
        return inorder1.equals(inorder2);
    }

    public List<Integer> visitInOrder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if (root != null) {
            inorder.addAll(visitInOrder(root.left));
            inorder.add(root.val);
            inorder.addAll(visitInOrder(root.right));
        }
        return inorder;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return visitInOrder(p, q);
    }

    public boolean visitInOrder(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        boolean result;
        if (root1 != null && root2 != null) {
            if (!visitInOrder(root1.left, root2.left)) {
                result = false;
            } else {
                if (root1.val != root2.val) {
                    result = false;
                } else {
                    if (!visitInOrder(root1.right, root2.right)) {
                        result = false;
                    } else {
                        result = true;
                    }
                }
            }
        } else {
            result = false;
        }
        return result;

    }
}
