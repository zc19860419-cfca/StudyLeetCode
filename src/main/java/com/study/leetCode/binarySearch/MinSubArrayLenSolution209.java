package com.study.leetCode.binarySearch;

import java.util.Arrays;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * Related Topics 数组 双指针 二分查找
 */
public class MinSubArrayLenSolution209 {
    /**
     * 蠕虫()
     * 定义两个指针 start 和 end 分别表示子数组（滑动窗口窗口）的开始位置和结束位置，
     * 维护变量 sum 存储子数组中的元素和（即从 nums[start] 到 nums[end] 的元素和）。
     * <p>
     * 初始状态下，start 和 end 都指向下标 0，sum 的值为 0。
     * <p>
     * 每一轮迭代，将 nums[end] 加到 sum，如果  sum≥target，则更新子数组的最小长度（此时子数组的长度是 end−start+1），
     * 然后将 nums[start] 从 sum 中减去并将 start 右移，直到  sum<target，在此过程中同样更新子数组的最小长度。
     * 在每一轮迭代的最后，将 end 右移。
     * <p>
     * 时间复杂度：O(n)，其中 n 是数组的长度。指针 start 和 end 最多各移动 n 次。
     * 空间复杂度：O(1)。
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int ans;
        int n = nums.length;
        if (n == 0) {
            ans = 0;
        } else {
            ans = Integer.MAX_VALUE;
            int start = 0, end = 0;
            int sum = 0;
            while (end < n) {
                sum += nums[end];
                while (sum >= target) {
                    ans = Math.min(ans, end - start + 1);
                    sum -= nums[start];
                    start++;
                }
                end++;
            }
            ans = (ans == Integer.MAX_VALUE ? 0 : ans);
        }
        return ans;
    }

    /**
     * 为了使用二分查找，需要额外创建一个数组 sums 用于存储数组 nums 的前缀和，其中 sums[i] 表示从 nums[0] 到 nums[i−1] 的元素和。
     * 得到前缀和之后，对于每个开始下标 i，可通过二分查找得到大于或等于 i 的最小下标 bound，
     * 使得 sums[bound]−sums[i−1]≥target，并更新子数组的最小长度（此时子数组的长度是 bound−(i−1)）。
     * <p>
     * 因为这道题保证了数组中每个元素都为正，所以前缀和一定是递增的，这一点保证了二分的正确性。如果题目没有说明数组中每个元素都为正，这里就不能使用二分来查找这个位置了。
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans;

        if (n == 0) {
            ans = 0;
        } else {
            ans = Integer.MAX_VALUE;
            int[] sums = new int[n + 1];
            // 为了方便计算，令 size = n + 1
            // sums[0] = 0 意味着前 0 个元素的前缀和为 0
            // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
            // 以此类推
            sums[0] = 0;
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
            int sum;
            int bound;
            for (int i = 1; i <= n; i++) {
                sum = target + sums[i - 1];
                bound = Arrays.binarySearch(sums, sum);
                //sums[bound]≥target+sums[i−1]
                if (bound < 0) {
                    //bound=-1
                    bound = -bound - 1;
                }
                if (bound <= n) {
                    ans = Math.min(ans, bound - (i - 1));
                }
            }
            ans = (ans == Integer.MAX_VALUE ? 0 : ans);
        }
        return ans;
    }


}
