package com.study.leetCode.binarySearch;

/**
 * @Author: zhangchong
 * @Description: 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 * <p>
 * Related Topics 数学 二分查找
 */
public class DivideSolution29 {
    /**
     * dividend/divisor=[0,divisor]
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;
        boolean isNeg = (x > 0 && y < 0) || (x < 0 && y > 0);
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        long l = 0, r = x;
        long mid;
        while (l < r) {
            mid = l + ((r - l + 1) >> 1);
            if (mul(mid, y) <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        long ans = isNeg ? -l : l;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            ans = Integer.MAX_VALUE;
        }
        return (int) ans;
    }

    long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans += a;
            }
            k >>= 1;
            a += a;
        }
        return ans;
    }
}
