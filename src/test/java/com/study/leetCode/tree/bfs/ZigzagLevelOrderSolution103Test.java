package com.study.leetCode.tree.bfs;

import com.study.leetCode.tree.TreeNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class ZigzagLevelOrderSolution103Test {

    private ZigzagLevelOrderSolution103 solution103;

    @Before
    public void setUp() throws Exception {
        solution103 = new ZigzagLevelOrderSolution103();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void zigzagLevelOrder() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        List<List<Integer>> zigzagLevelOrder = solution103.zigzagLevelOrder(root);
        System.out.println(zigzagLevelOrder);
        Assert.assertEquals(3, zigzagLevelOrder.size());
        Assert.assertArrayEquals(new int[]{3}, zigzagLevelOrder.get(0).stream().mapToInt(Integer::valueOf).toArray());
        Assert.assertArrayEquals(new int[]{20, 9}, zigzagLevelOrder.get(1).stream().mapToInt(Integer::valueOf).toArray());
        Assert.assertArrayEquals(new int[]{15, 7}, zigzagLevelOrder.get(2).stream().mapToInt(Integer::valueOf).toArray());
    }

    @Test
    public void zigzagLevelOrder_empty() {
        TreeNode root = null;
        List<List<Integer>> zigzagLevelOrder = solution103.zigzagLevelOrder(root);
        System.out.println(zigzagLevelOrder);
        Assert.assertEquals(0, zigzagLevelOrder.size());
    }
}