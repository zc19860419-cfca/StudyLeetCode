package com.study.leetCode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangchong
 * @Description: 651. 4键键盘
 * 假设你有一个特殊的键盘包含下面的按键：
 * <p>
 * Key 1: (A)：在屏幕上打印一个 'A'。
 * <p>
 * Key 2: (Ctrl-A)：选中整个屏幕。
 * <p>
 * Key 3: (Ctrl-C)：复制选中区域到缓冲区。
 * <p>
 * Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
 * <p>
 * 现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A'呢？
 * <p>
 * 样例 1:
 * <p>
 * 输入: N = 3
 * 输出: 3
 * 解释:
 * 我们最多可以在屏幕上显示三个'A'通过如下顺序按键：
 * A, A, A
 * <p>
 * <p>
 * 样例 2:
 * <p>
 * 输入: N = 7
 * 输出: 9
 * 解释:
 * 我们最多可以在屏幕上显示九个'A'通过如下顺序按键：
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 * <p>
 * <p>
 * 注释:
 * <p>
 * 1 <= N <= 50
 * 结果不会超过 32 位有符号整数范围。
 */
public class FourKeysKeyboardSolution651 {
    private Map<String, Integer> memory = new HashMap<>();

    public int maxA(int N) {
        int[] dp = new int[N + 1];
        //dp[i] 表示 i 次操作之后屏幕上能最多显示多少个 A
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            // 按 A 键
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // j 变量减 2 是给  C-A C-C  留下操作数
                // 全选 & 复制 dp[j-2]，连续粘贴 i - j 次
                // 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        // N 次按键之后最多有⼏个 A？
        return dp[N];
    }

    public int maxATimeout(int N) {
        return dp(N, 0, 0);
    }

    private int dp(int n, int aCount, int copy) {
        int result;
        if (n <= 0) {
            result = aCount;
        } else {
            final String key = n + "#" + aCount + "#" + copy;
            if (memory.containsKey(key)) {
                result = memory.get(key);
            } else {
                result = Math.max(
                        /*A*/
                        dp(n - 1, aCount + 1, copy),
                        /*C-A C-C*/
                        dp(n - 2, aCount, aCount)
                );
                result = Math.max(
                        result,
                        /*C-A C-V*/
                        dp(n - 1, aCount + copy, copy)
                );
                memory.put(key, result);
            }
        }
        return result;

    }
}
