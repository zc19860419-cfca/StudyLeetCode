package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class LongestPalindromeSolution5 {
    public String longestPalindrome(String s) {
        String result = "";
        final int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int j;
        for (int length = 0; length < n; length++) {
            for (int i = 0; i + length < n; i++) {
                j = i + length;
                if (length == 0) {
                    dp[i][j] = true;
                } else if (length == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && length >= result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}
