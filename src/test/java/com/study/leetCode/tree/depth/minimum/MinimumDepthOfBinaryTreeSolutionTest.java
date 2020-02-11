package com.study.leetCode.tree.depth.minimum;

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
public class MinimumDepthOfBinaryTreeSolutionTest {

    private MinimumDepthOfBinaryTreeSolution minimumDepthOfBinaryTreeSolution;

    @Before
    public void setUp() throws Exception {
        minimumDepthOfBinaryTreeSolution = new MinimumDepthOfBinaryTreeSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void minDepth1() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        final int minDepth = minimumDepthOfBinaryTreeSolution.minDepth(root);
        System.out.println(minDepth);
        Assert.assertEquals(2, minDepth);
    }

    @Test
    public void minDepth2() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.left = node1;
        final int minDepth = minimumDepthOfBinaryTreeSolution.minDepth(root);
        System.out.println(minDepth);
        Assert.assertEquals(2, minDepth);
    }
}