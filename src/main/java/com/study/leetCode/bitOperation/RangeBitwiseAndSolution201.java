package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description: 201. 数字范围按位与
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 5, right = 7
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：left = 0, right = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：left = 1, right = 2147483647
 * 输出：0
 * Constraints:
 * <p>
 * <p>
 * 0 <= left <= right <= 2^31 - 1
 * <p>
 * Related Topics 位运算
 */
public class RangeBitwiseAndSolution201 {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            //将最低位(LSB)的 1 清零
            right &= (right - 1);
        }
        //直到找到 right中能与left 对齐的最高位的那个1
        return right;
    }
}
