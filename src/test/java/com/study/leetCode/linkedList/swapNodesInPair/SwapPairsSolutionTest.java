package com.study.leetCode.linkedList.swapNodesInPair;

import com.study.leetCode.linkedList.swapNodesInPair.SwapPairsSolution.ListNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class SwapPairsSolutionTest {

    private SwapPairsSolution swapPairsSolution;

    @Before
    public void setUp() throws Exception {
        swapPairsSolution = new SwapPairsSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void swapPairs() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode swapedHead = swapPairsSolution.swapPairs(node1);
        Assert.assertEquals(node2, swapedHead);
        Assert.assertEquals(node1, swapedHead.next);
        Assert.assertEquals(node4, swapedHead.next.next);
        Assert.assertEquals(node3, swapedHead.next.next.next);
    }
}