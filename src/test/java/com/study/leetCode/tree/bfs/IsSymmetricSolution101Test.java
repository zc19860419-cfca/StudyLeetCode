package com.study.leetCode.tree.bfs;

import com.study.leetCode.tree.TreeNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class IsSymmetricSolution101Test {

    private IsSymmetricSolution101 solution101;

    @Before
    public void setUp() throws Exception {
        solution101 = new IsSymmetricSolution101();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isSymmetric() {
//        [1,2,2,3,4,4,3]
        TreeNode node2left3 = new TreeNode(3);
        TreeNode node2right4 = new TreeNode(4);
        TreeNode node2left4 = new TreeNode(4);
        TreeNode node2right3 = new TreeNode(3);

        TreeNode node1left2 = new TreeNode(2);
        node1left2.left = node2left3;
        node1left2.right = node2right4;

        TreeNode node1right2 = new TreeNode(2);
        node1right2.left = node2left4;
        node1right2.right = node2right3;

        TreeNode root = new TreeNode(1);
        root.left = node1left2;
        root.right = node1right2;

        Assert.assertTrue(solution101.isSymmetric(root));
    }
}