package com.study.leetCode.binarySearch;

/**
 * @Author: zhangchong
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums 是一个非递减数组
 * -10^9 <= target <= 10^9
 * <p>
 * Related Topics 数组 二分查找
 */
public class SearchRangeSolution34 {
    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }
        int first = findFirstIndex(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = findLastIndex(nums, target);
        return new int[]{first, last};
    }

    private int findFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
//            System.out.println("findFirstIndex=(" + left + "," + mid + "," + right + ") num=" + nums[mid]);
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (nums[left] != target) {
            left = -1;
        }
        return left;
    }

    private int findLastIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + ((right - left + 1) >> 1)/*(left + right + 1) >>> 1*/;
//            System.out.println("findFirstIndex=(" + left + "," + mid + "," + right + ") num=" + nums[mid]);
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}
