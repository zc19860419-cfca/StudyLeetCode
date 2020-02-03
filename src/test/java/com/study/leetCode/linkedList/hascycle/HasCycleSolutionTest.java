package com.study.leetCode.linkedList.hascycle;

import com.study.leetCode.linkedList.hascycle.HasCycleSolution.ListNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class HasCycleSolutionTest {

    private HasCycleSolution hasCycleSolution;

    @Before
    public void setUp() throws Exception {
        hasCycleSolution = new HasCycleSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hasCycle1() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        Assert.assertTrue(hasCycleSolution.hasCycle(head));
    }

    @Test
    public void hasCycle2() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);

        head.next = node1;
        node1.next = head;
        Assert.assertTrue(hasCycleSolution.hasCycle(head));
    }

    @Test
    public void hasCycle3() {
        ListNode head = new ListNode(1);
        Assert.assertFalse(hasCycleSolution.hasCycle(head));
    }
}