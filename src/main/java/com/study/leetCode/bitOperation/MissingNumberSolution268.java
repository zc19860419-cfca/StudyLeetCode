package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description: 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 * <p>
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 4：
 * <p>
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 * 提示限制:
 * <p>
 * n == nums.length
 * 1 <= n <= 10^4
 * 0 <= nums[i] <= n
 * 所有数字都是唯一的.
 * <p>
 * Related Topics 位运算 数组 哈希表 数学 排序
 */
public class MissingNumberSolution268 {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        //0^nums[0]^1^nums[1]^2^nums[2]...^(n-1)^nums[n-1]
        for (int i = 0; i < nums.length; i++) {
            //优先运行 i ^ nums[i]
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * 最快解法
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        long count = 0;
        long all = (long) (1 + nums.length) * nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }

        return (int) (all - count);
    }
}
