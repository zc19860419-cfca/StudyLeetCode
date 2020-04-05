package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description: 326. 3的幂
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: 27
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: 0
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: 9
 * Output: true
 * <p>
 * Example 4:
 * <p>
 * <p>
 * Input: 45
 * Output: false
 * <p>
 * Follow up:
 * Could you do it without using any loop / recursion? Related Topics 数学
 */


//leetcode submit region begin(Prohibit modification and deletion)
public class PowerOfThreeSolution {
    public boolean isPowerOfThree(int n) {
        //return n > 0 && 1162261467 % n == 0;
        return Integer.toString(n, 3).matches("^10*$");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

