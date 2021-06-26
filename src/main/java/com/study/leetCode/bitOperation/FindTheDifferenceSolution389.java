package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description: 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * Constraints:
 * <p>
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s and t consist of lower-case English letters.
 * <p>
 * Related Topics 位运算 哈希表 字符串 排序
 */
public class FindTheDifferenceSolution389 {
    /**
     * 如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符。
     * 类似于「136. 只出现一次的数字」，我们使用位运算的技巧解决本题
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
}
