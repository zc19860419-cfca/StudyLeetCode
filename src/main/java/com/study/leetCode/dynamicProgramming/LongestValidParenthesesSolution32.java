package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 * elated Topics 字符串 动态规划
 */
public class LongestValidParenthesesSolution32 {
    public int longestValidParentheses(String s) {
        int max = 0;
        if (s != null && s.length() > 1) {
            final int length = s.length();
            int[] dp = new int[length];
            for (int i = 0; i < length; i++) {
                dp[i] = 0;
            }

            int S2;
            int S1;
            for (int i = 1; i < length; i++) {
                if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    S2 = dp[i - 1];

                    if (i - dp[i - 1] - 2 >= 0) {
                        S1 = dp[i - dp[i - 1] - 2];
                    } else {
                        S1 = 0;
                    }
                    dp[i] = S2 + 2 + S1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
