package com.study.leetCode.binarySearch;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 * Topics 数组 二分查找
 */
public class FindPeakSolution162 {
    public int findPeakElement1(int[] nums) {
        int peak = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                peak = i;
                break;
            }
        }
        return peak;
    }

    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        int peek;
        if (left == right) {
            peek = left;
        } else {
            int mid = left + ((right - left) >>> 1);

            if (nums[mid] > nums[mid + 1]) {
                // 位于下降区段 峰值在本元素的左边 搜索区间变为[left, mid]
                peek = binarySearch(nums, left, mid);
            } else {
                // nums[mid] <= nums[mid + 1]
                // 位于上升区段 峰值在本元素的右边 搜索区间变为[mid + 1, right]
                peek = binarySearch(nums, mid+1, right);
            }
        }
        return peek;
    }
}
