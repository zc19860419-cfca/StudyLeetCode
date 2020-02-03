package com.study.leetCode.linkedList.swapNodesInPair;

/**
 * @Author: zhangchong
 * @Description:
 */
//Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged.
//
//
//
// Example:
//
//
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class SwapPairsSolution {

    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode firstNode;
        ListNode secondNode;

        //虚拟节点充当列表的头节点的 prevNode,因此存储指向头节点的指针
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //dummy     ->head      ->secondNode->
        //prevNode  ->firstNode ->secondNode->
        ListNode prevNode = dummy;

        while (null != head && null != head.next) {
            firstNode = head;
            secondNode = head.next;

            //prevNode->firstNode->secondNode->
            prevNode.next = secondNode;
            //prevNode->secondNode
            firstNode.next = secondNode.next;
            //       secondNode->A
            //firstNode--------->|
            secondNode.next = firstNode;
            //secondNode->firstNode
            //prevNode->secondNode->firstNode->

            prevNode = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }

    public static class ListNode {
        final int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ListNode{");
            sb.append("val=").append(val);
            sb.append('}');
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            boolean result;
            if (this == o) {
                result = true;
            } else if (o == null || getClass() != o.getClass()) {
                result = false;
            } else {
                ListNode listNode = (ListNode) o;
                result = val == listNode.val &&
                        Objects.equals(next, listNode.next);
            }
            return result;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

