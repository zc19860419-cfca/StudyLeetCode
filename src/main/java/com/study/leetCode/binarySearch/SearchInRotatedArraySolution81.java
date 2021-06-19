package com.study.leetCode.binarySearch;

/**
 * @Author: zhangchong
 * @Description: 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 * Related Topics 数组 二分查找
 */
public class SearchInRotatedArraySolution81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0;
        int r = n - 1;
        int mid;
        while (l <= r) {
            //当前搜素区间 [l, r]
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return true;
            }
//            对于数组中有重复元素的情况，二分查找时可能会有 a[l]=a[mid]=a[r]，此时无法判断区间 [l,mid] 和区间 [mid+1,r] 哪个是有序的。
//            例如 nums=[3,1,2,3,3,3,3]，target=2，首次二分时无法判断区间 [0,3][0,3] 和区间 [4,6][4,6] 哪个是有序的。
//            对于这种情况，我们只能将当前二分区间的左边界加一，右边界减一，然后在新区间上继续二分查找。
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                //说明[l, mid] 是升序区间，可以进行二分搜索
                if (nums[l] <= target && target < nums[mid]) {
                    // target in [l, mid]->下次搜素区间 ==>[l, mid-1]
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
                    // target in [l, mid-1]->下次搜素区间 ==>[l, mid-1]
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
