package com.study.leetCode.binarySearch;

/**
 * @Author: zhangchong
 * @Description: 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 */
public class MyPowSolution50 {
    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    /**
     * x→x^2 →x^4 →x^9 →x^19 →x^38 →x^77 的顺序，在 x→x^2 ，x^2→x^4 ，x^19 → x^38 这些步骤中，
     * 我们直接把上一次的结果进行平方，而在 x^4 →x^9，x^9 →x^19 ，x^38 → x^77这些步骤中，
     * 我们把上一次的结果进行平方后，还要额外乘一个 x。
     *
     * @param x
     * @param n
     * @return
     */
    private double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n >> 1);
        return (n % 2 == 0) ? y * y : y * y * x;

    }
}
