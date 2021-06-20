package com.study.leetCode.binarySearch;

/**
 * @Author: zhangchong
 * @Description: 410. 分割数组的最大值
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * <p>
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 * 示例 3：
 * <p>
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 * Related Topics 二分查找 动态规划
 */


//leetcode submit region begin(Prohibit modification and deletion)
public class SplitArrayLargestSumSolution410 {
    /**
     * 二分查找 + 贪心
     * 思路及算法
     * <p>
     * 「使……最大值尽可能小」是二分搜索题目常见的问法。
     * <p>
     * 本题中，我们注意到：当我们选定一个值 x，我们可以线性地验证是否存在一种分割方案，满足其最大分割子数组和不超过 x。
     * 策略如下：
     * 贪心地模拟分割的过程，从前到后遍历数组，用 sum 表示当前分割子数组的和，cnt 表示已经分割出的子数组的数量（包括当前子数组），
     * 那么每当 sum 加上当前值超过了 x，我们就把当前取的值作为新的一段分割子数组的开头，并将 cnt 加 1。
     * 遍历结束后验证是否 cnt 不超过 m。
     * <p>
     * 这样我们可以用二分查找来解决。二分的上界为数组 nums 中所有元素的和，下界为数组 nums 中所有元素的最大值。
     * 通过二分查找，我们可以得到最小的最大分割子数组和，这样就可以得到最终的答案了。
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        //首先构建上界下界
        // 下界为数组 nums 中所有元素的最大值
        int left = 0;
        // 上界为数组 nums 中所有元素的和
        int right = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }

        int mid;
        //搜索区间为[left,right]
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (check(nums, mid, m)) {
                //最大值是 mid 的情况下，满足分割方式，调小最大值范围
                right = mid;
            } else {
                //最大值是 mid 的情况下，不满足分割方式，调大最大值范围
                left = mid + 1;
            }
        }
        return left;
    }

    /***
     * 贪心地模拟分割的过程:
     * 从前到后遍历数组，用 sum 表示当前分割子数组的和，cnt 表示已经分割出的子数组的数量（包括当前子数组），
     * 那么每当 sum 加上当前值超过了 x，我们就把当前取的值作为新的一段分割子数组的开头，并将 cnt 加 1。
     * 遍历结束后验证是否 cnt 不超过 m。
     *
     * @param nums
     * @param x
     * @param m
     * @return
     */
    private boolean check(int[] nums, int x, int m) {
        int sum = 0;
        //初始值就是1
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

}

