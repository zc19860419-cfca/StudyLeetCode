package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description: 231. 2的幂
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: 218
 * Output: false
 * Related Topics 位运算 数学
 */


//leetcode submit region begin(Prohibit modification and deletion)
public class PowerOfTwoSolution {
    public boolean isPowerOfTwo(int n) {
        long x = (long) n;
        return 0 != x && 0 == (x & (x - 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

