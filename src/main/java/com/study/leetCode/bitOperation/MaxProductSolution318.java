package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description: 318. 最大单词长度乘积
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
 * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。
 * 如果不存在这样的两个单词，返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 * <p>
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * <p>
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] consists only of lowercase English letters.
 * <p>
 * Related Topics 位运算 数组 字符串
 */
public class MaxProductSolution318 {
    public int maxProduct(String[] words) {
        int res = 0;
        int n = words.length;
        int[] bitmasks = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0, len1 = words[i].length(); j < len1; j++) {
                bitmasks[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bitmasks[i] & bitmasks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }
}
