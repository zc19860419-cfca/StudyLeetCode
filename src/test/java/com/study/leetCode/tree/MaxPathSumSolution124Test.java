package com.study.leetCode.tree;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class MaxPathSumSolution124Test {

    private MaxPathSumSolution124 solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaxPathSumSolution124();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_maxPathSum1() {
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        TreeNode root = new TreeNode(1);
        root.left = rootLeft;
        root.right = rootRight;

        Assert.assertEquals(6, solution.maxPathSum(root));
    }

    @Test
    public void test_maxPathSum2() {
        TreeNode rootLeft = new TreeNode(9);

        TreeNode rootRLeft = new TreeNode(15);
        TreeNode rootRRight = new TreeNode(7);
        TreeNode rootRight = new TreeNode(20);
        rootRight.left = rootRLeft;
        rootRight.right = rootRRight;

        TreeNode root = new TreeNode(-10);
        root.left = rootLeft;
        root.right = rootRight;

        Assert.assertEquals(42, solution.maxPathSum(root));
    }
}