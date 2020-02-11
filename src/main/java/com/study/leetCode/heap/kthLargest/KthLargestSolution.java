package com.study.leetCode.heap.kthLargest;

import java.util.PriorityQueue;

/**
 * @Author: zhangchong
 * @Description: Design a class to find the kth largest element in a stream. Note that it is th
 * e kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and
 * an integer array nums, which contains initial elements from the stream. For each
 * call to the method KthLargest.add, return the element representing the kth larg
 * est element in the stream.
 * <p>
 * Example:
 * <p>
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * <p>
 * <p>
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 * Related Topics 堆
 */
//leetcode submit region begin(Prohibit modification and deletion)
class KthLargestSolution {

    private final PriorityQueue<Integer> queue;
    private final int k;

    public KthLargestSolution(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (k > queue.size()) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

