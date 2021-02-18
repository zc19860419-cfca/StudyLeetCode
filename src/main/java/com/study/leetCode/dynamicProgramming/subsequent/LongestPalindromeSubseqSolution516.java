package com.study.leetCode.dynamicProgramming.subsequent;

/**
 * @Author: zhangchong
 * @Description: 516. 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * <p>
 * 示例 1:
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * "cbbd"
 * 输出:
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 */
public class LongestPalindromeSubseqSolution516 {
    public int longestPalindromeSubseq(String s) {
        final int nCount = s.length();
        System.out.println("[" + nCount + "]s=" + s);
        int[][] dp = new int[nCount][nCount];
        for (int i = 0; i < nCount; i++) {
            for (int j = 0; j < nCount; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = nCount - 1; i >= 0; i--) {
            for (int j = i + 1; j < nCount; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    System.out.println("\tdp[" + (i + 1) + "][" + (j - 1) + "]=" + dp[i + 1][j - 1] + "+2");
                } else if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    System.out.println("\tdp[" + i + "][" + (j - 1) + "]=" + dp[i][j - 1]);
                    System.out.println("\tdp[" + (i + 1) + "][" + j + "]=" + dp[i + 1][j]);
                }
                System.out.println("dp[" + i + "][" + j + "]=" + dp[i][j]);

            }
        }
        return dp[0][nCount - 1];
    }
}
