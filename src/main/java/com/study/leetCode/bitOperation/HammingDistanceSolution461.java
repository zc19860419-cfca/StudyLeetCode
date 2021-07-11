package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description: <pre>
 * 461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 *  给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * <p>
 * <p>
 *  示例 1：
 * <p>
 *  输入：x = 1, y = 4
 *  输出：2
 *  解释：
 *  1   (0 0 0 1)
 *  4   (0 1 0 0)
 *         ↑   ↑
 *  上面的箭头指出了对应二进制位不同的位置。
 *  示例 2：
 * <p>
 *  输入：x = 3, y = 1
 *  输出：1
 * <p>
 *  Constraints:
 * <p>
 * <p>
 *  0 <= x, y <= 2^31 - 1
 * <p>
 * </pre>
 * <p>
 * Related Topics 位运算
 */
public class HammingDistanceSolution461 {
    public int hammingDistance(int x, int y) {
        int distance = x ^ y;
        int count = 0;
        while (distance > 0) {
            distance &= (distance - 1);
            count++;
        }

        return count;
    }
}
