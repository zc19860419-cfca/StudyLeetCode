package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: 97. 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * <p>
 * Follow up: Could you solve it using only O(s2.length) additional memory space?
 * Related Topics 字符串 动态规划
 */
public class isInterleaveSolution97 {
    private char[] str1, str2, str3;
    private int m, n, t;
    private boolean[][] visited;

    public boolean isInterleave(String s1, String s2, String s3) {
        str1 = s1.toCharArray();
        str2 = s2.toCharArray();
        str3 = s3.toCharArray();
        m = str1.length;
        n = str2.length;
        t = str3.length;
        if (m + n != t) {
            return false;
        }
        visited = new boolean[m + 1][n + 1];
        return isInterleave(0, 0);
    }

    // 判断 str1[i, m) 与 str2[j, n) 能否交错形成 str3[i + j, t)。
    private boolean isInterleave(int i, int j) {
        if (i + j == t) {
            return true;
        }
        visited[i][j] = true;
        if (i < m && str1[i] == str3[i + j] && !visited[i + 1][j] && isInterleave(i + 1, j)) {
            return true;
        }
        return j < n && str2[j] == str3[i + j] && !visited[i][j + 1] && isInterleave(i, j + 1);
    }

    /**
     * 解决这个问题的正确方法是动态规划。
     * 首先如果 |s1| + |s2| != |s3|，那 s3 必然不可能由 s1 和 s2 交错组成。
     * 在 |s1| + |s2| = |s3| 时，我们可以用动态规划来求解。
     * 我们定义 f(i, j)表示 s1 的前 i 个元素和 s2的前 j 个元素是否能交错组成 s3 的前 i + j 个元素。
     * 如果 s1 的第 i 个元素和 s3的第 i + j 个元素相等，那么 s1的前 i 个元素和 s2的前 j 个元素是否能交错组成 s3的前 i + j 个元素取决于 s1的前 i - 1 个元素和 s2的前 j 个元素是否能交错组成 s3的前 i + j - 1 个元素，即此时
     * f(i, j) 取决于 f(i - 1, j)，在此情况下如果 f(i - 1, j) 为真，则 f(i, j)也为真。
     * 同样的，如果 s2的第 j 个元素和 s3的第 i + j 个元素相等并且 f(i, j - 1) 为真，则 f(i, j) 也为真。于是我们可以推导出这样的动态规划转移方程：
     * f(i, j) = [f(i - 1, j) and s1(i - 1) == s3(p)] or [f(i, j - 1) and s2(j - 1) == s3(p)]
     * 其中 p = i + j - 1。
     * 边界条件为 f(0, 0) = True。
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave1(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int t = s3.length();
        boolean isInterleave = false;
        if (m + n == t) {
            boolean f[][] = new boolean[m + 1][n + 1];

            f[0][0] = true;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    int p = i + j - 1;
                    if (i > 0) {
                        f[i][j] = f[i][j] || (f[i - 1][j] && s3.charAt(p) == s1.charAt(i - 1));
                    }
                    if (j > 0) {
                        f[i][j] = f[i][j] || (f[i][j - 1] && s3.charAt(p) == s2.charAt(j - 1));
                    }
                }
            }
            isInterleave = f[m][n];
        }
        return isInterleave;
    }


    public boolean isInterleave2(String s1, String s2, String s3) {
        boolean isInterleave = false;

        int m = s1.length();
        int n = s2.length();
        int t = s3.length();
        if (m + n == t) {
            boolean f[] = new boolean[n + 1];
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            char[] c3 = s3.toCharArray();

            f[0] = true;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    int p = i + j - 1;
                    if (i > 0) {
                        f[j] = (f[j] && c3[p] == c1[i - 1]);
                    }
                    if (j > 0) {
                        f[j] = (f[j] || (f[j - 1] && c3[p] == c2[j - 1]));
                    }
                }
            }
            isInterleave = f[n];
        }
        return isInterleave;
    }

    public boolean isInterleave3(String s1, String s2, String s3) {
        boolean isInterleave = false;

        int m = s1.length();
        int n = s2.length();
        int t = s3.length();
        if (m + n == t) {
            boolean f[] = new boolean[n + 1];
            f[0] = true;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    int p = i + j - 1;
                    if (i > 0) {
                        f[j] = (f[j] && s3.charAt(p) == s1.charAt(i - 1));
                    }
                    if (j > 0) {
                        f[j] = (f[j] || (f[j - 1] && s3.charAt(p) == s2.charAt(j - 1)));
                    }
                }
            }
            isInterleave = f[n];
        }
        return isInterleave;
    }
}
