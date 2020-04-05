package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description: 191. 位1的个数
 * Write a function that takes an unsigned integer and return the number of '1' b
 * its it has (also known as the Hamming weight).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a to
 * tal of three '1' bits.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a to
 * tal of one '1' bit.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a to
 * tal of thirty one '1' bits.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * <p>
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, the input will be given as signed integer type and should not affe
 * ct your implementation, as the internal binary representation of the integer is
 * the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement not
 * ation. Therefore, in Example 3 above the input represents the signed integer -3.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * If this function is called many times, how would you optimize it?
 * Related Topics 位运算
 */
//leetcode submit region begin(Prohibit modification and deletion)
public class HammingWeightSolution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (0 != n) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

