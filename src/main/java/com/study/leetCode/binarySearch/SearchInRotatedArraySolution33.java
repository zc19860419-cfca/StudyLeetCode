package com.study.leetCode.binarySearch;

/**
 * @Author: zhangchong
 * @Description: Related Topics 数组 二分查找
 */
public class SearchInRotatedArraySolution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            //当前搜素区间 [l, r]
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                //说明[0, mid] 是升序区间，可以进行二分搜索
                if (nums[0] <= target && target < nums[mid]) {
                    // target in [0, mid]->下次搜素区间 ==>[l, mid-1]
                    r = mid - 1;
                } else {
                    // target in [mid+1, r]->下次搜素区间 ==>[mid+1, r]
                    l = mid + 1;
                }
            } else {
                //说明[mid,r] 是升序区间，可以进行二分搜索
                if (nums[mid] < target && target <= nums[n - 1]) {
                    // target in [mid, n-1]->下次搜素区间 ==>[mid+1, r]
                    l = mid + 1;
                } else {
                    // target in [0, mid-1]->下次搜素区间 ==>[l, mid-1]
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    static class SearchHelper {
        public static int search(int[] nums, int left, int right, int target) {
            return left;
        }
    }
}
