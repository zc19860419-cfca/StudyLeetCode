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

    /**
     * 动态规划主函数
     * 整个表格区域应该是分为三部分：-/0/+。
     * 那么对应的表格的每一行的长度t就可以表示为：t=(sum*2)+1，其中一个sum表示nums中执行全部执行加/减能达到的数，
     * <p>
     * 作者：keepal
     * 链接：https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-si-kao-quan-guo-cheng-by-keepal/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param s
     * @return
     */
    public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 绝对值范围超过了sum的绝对值范围则无法得到
        if (Math.abs(s) > Math.abs(sum)) {
            return 0;
        }

        int len = nums.length;
        // - 0 +
        int t = sum * 2 + 1;
        /**
         * dp[i][j]表示使用前 [0..i] 个元素可以达到目标和为 j 的方案数
         */
        int[][] dp = new int[len][t];
        /**
         * 初始化
         */
        if (nums[0] == 0) {
            /**
             * 如果nums[0]==0 那么dp[0][sum]需要初始化为 2，因为加减 0 都得 0
             */
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < t; j++) {
                // 边界
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }
        return dp[len - 1][sum + s];
    }

    /**
     * 回溯法主函数
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays_backtrack(int[] nums, int target) {
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
     *             剩余数组元素[i+1..n-1] 将组成的和为 rest
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
