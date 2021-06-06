package com.study.leetCode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangchong
 * @Description: 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * Related Topics 深度优先搜索 动态规划 回溯算法
 */
public class PartitionPalindromeSolution131 {
    /**
     * 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
     */
    private static final int NOT_VISITED = 0;
    private static final int PALINDROME = 1;
    private static final int NOT_PALINDROME = -1;
    private List<List<String>> ret = new ArrayList<List<String>>();
    private List<String> ans = new ArrayList<>();
    private int[][] f;
    private int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);
        return ret;

    }

    private void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (int j = i; j < n; j++) {
            if (PALINDROME == isPalindrome(s, i, j)) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    private int isPalindrome(String s, int i, int j) {
        if (f[i][j] != NOT_VISITED) {
            return f[i][j];
        }

        if (i >= j) {
            f[i][j] = PALINDROME;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = NOT_PALINDROME;
        }
        return f[i][j];
    }
}
