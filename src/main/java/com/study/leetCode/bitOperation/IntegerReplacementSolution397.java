package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description: 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 * <p>
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：2
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 2^31 - 1
 * <p>
 * Related Topics 位运算 记忆化搜索 动态规划
 */
public class IntegerReplacementSolution397 {

    public int integerReplacement(int n) {
        int count = 0;

        long x = (long) n;
        while (x > 1) {
            if ((x & 1) == 0) {
                //如果 n 是偶数，则用 n/2 替换 n
                x = x >> 1;
            } else {
                //(....1)b
                //如果 n 是奇数，则可以用 n+1 或 n-1 替换 n
                //(...01)b  (00...11)b
                if ((x & 2) == 0 || x == 3) {
                    x--;
                } else {
                    //0111 1111 1111 1111 1111 1111 1111 1111
                    x++;
                }
            }

            count++;
        }
        return count;
    }
}
