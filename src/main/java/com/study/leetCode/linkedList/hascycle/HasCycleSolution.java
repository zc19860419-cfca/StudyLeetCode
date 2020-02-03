package com.study.leetCode.linkedList.hascycle;

/**
 * @Author: zhangchong
 * @Description:
 */

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class HasCycleSolution {
    public boolean hasCycle(ListNode head) {
        boolean result = false;
        ListNode slow;
        ListNode fast;
        slow = fast = head;
        while (null != slow && null != fast) {
            slow = slow.next;
            if (null != fast.next) {
                fast = fast.next.next;
                if (null != slow && slow.equals(fast)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static class ListNode {
        final int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
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

