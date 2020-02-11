package com.study.leetCode.tree.lowestCommonAncestor;

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
public class BSTLCABruteForceSolutionTest {

    private BSTLCABruteForceSolution bstLCABruteForceSolution;

    @Before
    public void setUp() throws Exception {
        bstLCABruteForceSolution = new BSTLCABruteForceSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lowestCommonAncestor1() {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node7;
        node4.right = node8;
        node2.left = node5;
        node2.right = node6;

        TreeNode p = node1;
        TreeNode q = node2;
        final TreeNode lowestCommonAncestor = bstLCABruteForceSolution.lowestCommonAncestor(root, p, q);
        System.out.println(lowestCommonAncestor);
        Assert.assertEquals(root, lowestCommonAncestor);
    }

    @Test
    public void lowestCommonAncestor2() {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node7;
        node4.right = node8;
        node2.left = node5;
        node2.right = node6;

        TreeNode p = node1;
        TreeNode q = node4;
        final TreeNode lowestCommonAncestor = bstLCABruteForceSolution.lowestCommonAncestor(root, p, q);
        System.out.println(lowestCommonAncestor);
        Assert.assertEquals(node1, lowestCommonAncestor);
    }
}