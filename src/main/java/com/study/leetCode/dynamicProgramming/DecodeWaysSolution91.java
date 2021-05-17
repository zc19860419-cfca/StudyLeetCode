package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 * Related Topics 字符串 动态规划
 */
public class DecodeWaysSolution91 {
    /**
     * 具体地，设 f_i表示字符串 s 的前 i 个字符 s[1..i] 的解码方法数。在进行状态转移时，我们可以考虑最后一次解码使用了 s 中的哪些字符，
     * 那么会有下面的两种情况：
     * <p>
     * 第一种情况是我们使用了一个字符，即 s[i] 进行解码，那么只要 s[i] != 0，
     * 它就可以被解码成 A∼I 中的某个字母。由于剩余的前 i-1 个字符的解码方法数为 f_{i-1}，
     * 因此我们可以写出状态转移方程：
     * <p>
     * f_i = f_{i-1},其中s[i]!=0
     * <p>
     * 第二种情况是我们使用了两个字符，即 s[i-1]和 s[i]进行编码。
     * 与第一种情况类似，s[i-1] 不能等于 0，并且 s[i-1] 和 s[i] 组成的整数必须小于等于 26，
     * 这样它们就可以被解码成 J∼Z 中的某个字母。由于剩余的前 i-2 个字符的解码方法数为 f_{i-2}，因此我们可以写出状态转移方程：
     * <p>
     * f_i = f_{i-2}, 其中s[i−1]!=0并且10⋅s[i−1]+s[i]≤26
     * <p>
     * 需要注意的是，只有当 i>1时才能进行转移，否则 s[i-1]不存在。
     * <p>
     * 将上面的两种状态转移方程在对应的条件满足时进行累加，即可得到 f_i
     * 的值。在动态规划完成后，最终的答案即为 f_n  。
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
