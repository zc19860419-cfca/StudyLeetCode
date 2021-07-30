package com.study.leetCode.tree.dfs;

import com.study.leetCode.tree.TreeNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class IsSameTreeSolution100Test {

    private IsSameTreeSolution100 solution;

    @Before
    public void setUp() throws Exception {
        solution = new IsSameTreeSolution100();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isSameTree_same() {
        TreeNode p = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        p.left = node1;
        p.right = node2;

        TreeNode q = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        q.left = node3;
        q.right = node4;
        Assert.assertTrue(solution.isSameTree(p, q));
    }

    @Test
    public void isSameTree_not_same() {
        TreeNode p = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        p.left = node1;

        TreeNode q = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        q.right = node3;
        Assert.assertFalse(solution.isSameTree(p, q));
    }

    @Test
    public void isSameTree_not_same1() {
        TreeNode p = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        p.left = node1;

        // 1 null 1
        TreeNode q = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        q.right = node3;
        Assert.assertFalse(solution.isSameTree(p, q));
    }
}