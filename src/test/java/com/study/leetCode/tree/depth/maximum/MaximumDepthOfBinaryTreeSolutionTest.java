package com.study.leetCode.tree.depth.maximum;

import com.study.leetCode.tree.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class MaximumDepthOfBinaryTreeSolutionTest {

    private MaximumDepthOfBinaryTreeSolution maximumDepthOfBinaryTreeSolution;

    @Before
    public void setUp() throws Exception {
        maximumDepthOfBinaryTreeSolution = new MaximumDepthOfBinaryTreeSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxDepth() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        final int minDepth = maximumDepthOfBinaryTreeSolution.maxDepth(root);
        System.out.println(minDepth);
    }
}