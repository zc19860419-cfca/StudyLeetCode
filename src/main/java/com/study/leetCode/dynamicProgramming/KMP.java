package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: KMP字符匹配算法
 * 先在开头约定，本⽂⽤  pat  表⽰模式串，⻓度为  M  ， txt  表⽰⽂本串，
 * ⻓度为  N  。KMP 算法是在  txt  中查找⼦串  pat  ，如果存在，返回这个
 * ⼦串的起始索引，否则返回 -1。
 * <p>
 * 本⽂则⽤⼀个⼆维的  dp  数组（但空间复杂度还是 O(M)），重新定
 * 义其中元素的含义，使得代码⻓度⼤⼤减少，可解释性⼤⼤提⾼。
 * <p>
 * KMP 算法永不回退  txt  的指针  i  ，不⾛回头路（不会重复扫描txt  ），
 * ⽽是借助  dp  数组中储存的信息把  pat  移到正确的位置继续匹
 * 配，时间复杂度只需 O(N)，⽤空间换时间，所以我认为它是⼀种动态规划
 * 算法。
 * <p>
 * KMP 算法的难点在于，如何计算  dp  数组中的信息？
 * 如何根据这些信息正确地移动  pat  的指针？这个就需要确定有限状态⾃动机来辅助
 * <p>
 * pat[j]的 j 不要理解为索引，它的含义更准确地说应该是状态（state）
 * <p>
 * 要确定状态转移的⾏为，得明确两个变量：
 * ⼀个是当前的匹配状态，另⼀个是遇到的字符
 * <p>
 * 构建状态转移图
 * 1.状态推进
 * 如果遇到的字符  c  和  pat[j]  匹配的话，状态就应该向前推进⼀个 next = j + 1
 * 2.状态重启
 * 如果字符  c  和  pat[j]  不匹配的话，状态就要回退（或者原地不动）
 * <p>
 * 影⼦状态：
 * ⽤变量  X  表⽰。所谓影⼦状态，就是和当前状态的前缀具有相同的前缀的状态
 */
public class KMP {
    private int[][] dp;
    private String pattern;

    public KMP(String pattern) {
        this.pattern = pattern;
        int M = pattern.length();

        //dp[状态]['字符'] = 下个状态
        dp = new int[M][256];
        //base case
        dp[0][pattern.charAt(0)] = 1;

        //影子状态 X 初始化为 0
        int X = 0;

        //构建状态转移图
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[X][c];
            }
            dp[j][pattern.charAt(j)] = j + 1;

            //更新影子状态
            X = dp[X][pattern.charAt(j)];
        }
    }

    public int search(String txt) {
        int M = pattern.length();
        int N = txt.length();
        //pattern 初始化为 0
        int j = 0;
        //遍历 txt
        for (int i = 0; i < N; i++) {
            //计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)];

            //到达终止态
            if (j == M) {
                return i - M + 1;
            }
        }
        return -1;
    }
}
