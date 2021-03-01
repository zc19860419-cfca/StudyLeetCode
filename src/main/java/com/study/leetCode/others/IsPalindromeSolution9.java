package com.study.leetCode.others;

/**
 * @Author: zhangchong
 * @Description: 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * Related Topics 数学
 */
public class IsPalindromeSolution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        final String s = Integer.toString(x);
        final int n = s.length();
        if (n == 1) {
            return true;
        }
        boolean isPalindrome = true;
        int head = 0;
        int tail = n - 1;
        while (head < tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                isPalindrome = false;
                break;
            }
            head++;
            tail--;
        }
        return isPalindrome;
    }
}
