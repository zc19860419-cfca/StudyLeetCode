package com.study.leetCode.tree.isValidBST;

import com.study.leetCode.tree.TreeNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class isValidBSTSolutionTest {

    private isValidBSTSolution validBSTSolution;

    @Before
    public void setUp() throws Exception {
        validBSTSolution = new isValidBSTSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isValidBST1() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        Assert.assertTrue(validBSTSolution.isValidBST(root));
    }

    @Test
    public void isValidBST2() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        Assert.assertFalse(validBSTSolution.isValidBST(root));
    }
}