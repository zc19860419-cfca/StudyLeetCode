package com.study.leetCode.linkedList.slidingWindow;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: zhangchong
 * @Description:
 */
//Given an array nums, there is a sliding window of size k which is moving from
//the very left of the array to the very right. You can only see the k numbers in
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window.
//
// Example:
//
//
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7]
//Explanation:
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// Note:
//You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty arr
//ay.
//
// Follow up:
//Could you solve it in linear time? Related Topics 堆 Sliding Window


//leetcode submit region begin(Prohibit modification and deletion)
public class SlidingWindowSolution {

    private static final int[] EMPTY_INT_ARRAY = new int[0];

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || 0 == nums.length) {
            return EMPTY_INT_ARRAY;
        }

        int[] results = new int[nums.length - k + 1];
        Deque<Integer> indexWindow = new ArrayDeque<>();
        int current;
        Integer leftmostIndex;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            //检测滑动窗口上下边界，超出则移除头部元素
            if (i >= k && (leftmostIndex = indexWindow.peekFirst()) != null && leftmostIndex.intValue() <= i - k) {
                indexWindow.pollFirst();
            }
            //将新元素与窗口中最右元素依次比较，比最右元素大则移除最右元素
            while (!indexWindow.isEmpty() && nums[indexWindow.peekLast().intValue()] <= current) {
                indexWindow.pollLast();
            }
            indexWindow.offerLast(Integer.valueOf(i));
            if (i >= k - 1) {
                results[count++] = nums[indexWindow.peekFirst().intValue()];
            }
        }
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)