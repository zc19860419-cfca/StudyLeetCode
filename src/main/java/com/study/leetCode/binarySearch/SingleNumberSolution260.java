package com.study.leetCode.binarySearch;

/**
 * @Author: zhangchong
 * @Description: 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 2 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 * <p>
 * Related Topics 位运算 数组
 */
public class SingleNumberSolution260 {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int ret = 0;
        //第一步：先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
        for (int i = 0; i < n; i++) {
            ret ^= nums[i];
        }

        //第二步：在异或结果中找到任意为 1 的位
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        //(div & ret) == 1
        // div就是那一位
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if ((div & nums[i]) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a, b};


    }
}
