package com.study.leetCode.divideAndConquer.majorityElement;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description Given an array of size n, find the majority element. The majority element is t
 * he element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always ex
 * ist in the array.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * Related Topics 位运算 数组 分治算法
 */

//leetcode submit region begin(Prohibit modification and deletion)
class MajorityElementSolution {
    /**
     * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 没有上述假设算法是肯定不对的，必须要对原始数据进行排序聚拢以后，至少能得出出现次数最多的数
     *
     * 时间复杂度：O(nlgn)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    /**
     * 分治递归求解
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int majorityElementRec(int[] nums, int low, int high) {
//        System.out.println("(" + low + "," + high + ")");
        int majorityElement;
        if (low == high) {
            majorityElement = nums[low];
        } else {
            int mid = low + (high - low) / 2;
//            System.out.println("(" + low + "," + high + ")->(" + low + "," + mid + ")+(" + (mid + 1) + "," + high + ")");
            int leftMajority = majorityElementRec(nums, low, mid);
            int rightMajority = majorityElementRec(nums, mid + 1, high);
            if (leftMajority == rightMajority) {
                majorityElement = leftMajority;
            } else {
                int leftCount = countInRange(nums, leftMajority, low, high);
                int rightCount = countInRange(nums, rightMajority, low, high);
                majorityElement = (leftCount > rightCount) ? leftMajority : rightMajority;
            }
        }
//        System.out.println("(" + low + "," + high + ")=" + majorityElement);
        return majorityElement;
    }

    private int countInRange(int[] nums, int majority, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (majority == nums[i]) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
