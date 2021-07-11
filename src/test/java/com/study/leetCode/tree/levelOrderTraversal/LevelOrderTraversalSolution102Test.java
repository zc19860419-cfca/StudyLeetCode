package com.study.leetCode.tree.levelOrderTraversal;

import com.study.leetCode.tree.TreeNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class LevelOrderTraversalSolution102Test {

    private LevelOrderTraversalSolution102 solution102;

    @Before
    public void setUp() throws Exception {
        solution102 = new LevelOrderTraversalSolution102();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void levelOrder1() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        final List<List<Integer>> levelOrder = solution102.levelOrder(root);
        System.out.println(levelOrder);
        Assert.assertEquals(3, levelOrder.size());
        Assert.assertArrayEquals(new int[]{3}, levelOrder.get(0).stream().mapToInt(Integer::valueOf).toArray());
        Assert.assertArrayEquals(new int[]{9, 20}, levelOrder.get(1).stream().mapToInt(Integer::valueOf).toArray());
        Assert.assertArrayEquals(new int[]{15, 7}, levelOrder.get(2).stream().mapToInt(Integer::valueOf).toArray());
    }
}