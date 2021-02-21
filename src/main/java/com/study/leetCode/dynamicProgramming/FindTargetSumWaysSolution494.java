package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description:494. 目标和
 * * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * <p>
 * <p>
 * 提示：
 * * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 * <p>
 * Related Topics 深度优先搜索 动态规划
 */
public class FindTargetSumWaysSolution494 {
    int result = 0;

    /* 回溯法主函数 */
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        backtrack(nums, 0, target);
        return result;
    }

    /**
     * 回溯算法模板
     *
     * @param nums
     * @param i
     * @param rest 使用了数组前 [0..i] 个元素组成的序列，其和为 target-rest
     */
    void backtrack(int[] nums, int i, int rest) {
        // base case
        if (i == nums.length) {
            if (rest == 0) {
                // 说明恰好凑出 target
                result++;
            }
            return;
        }
        // 给 nums[i] 选择 - 号
        rest += nums[i];
        // 穷举 nums[i + 1]
        backtrack(nums, i + 1, rest);
        // 撤销选择
        rest -= nums[i];

        // 给 nums[i] 选择 + 号
        rest -= nums[i];
        // 穷举 nums[i + 1]
        backtrack(nums, i + 1, rest);
        // 撤销选择
        rest += nums[i];
    }
}
