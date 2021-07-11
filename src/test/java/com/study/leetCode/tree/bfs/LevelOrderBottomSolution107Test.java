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
public class LevelOrderBottomSolution107Test {

    private LevelOrderBottomSolution107 solution107;

    @Before
    public void setUp() throws Exception {
        solution107 = new LevelOrderBottomSolution107();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void levelOrderBottom() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        List<List<Integer>> zigzagLevelOrder = solution107.levelOrderBottom(root);
        System.out.println(zigzagLevelOrder);
        Assert.assertEquals(3, zigzagLevelOrder.size());
        Assert.assertArrayEquals(new int[]{3}, zigzagLevelOrder.get(2).stream().mapToInt(Integer::valueOf).toArray());
        Assert.assertArrayEquals(new int[]{9, 20}, zigzagLevelOrder.get(1).stream().mapToInt(Integer::valueOf).toArray());
        Assert.assertArrayEquals(new int[]{15, 7}, zigzagLevelOrder.get(0).stream().mapToInt(Integer::valueOf).toArray());
    }
}