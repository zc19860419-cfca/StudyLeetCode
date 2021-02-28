package com.study.leetCode.others;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhangchong
 * @Description: 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * Related Topics 哈希表 双指针 字符串 Sliding Window
 */
public class LengthOfLongestSubstringSolution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = left + 1;
        // [left,right)
        Set<Character> occ = new HashSet<Character>();
        occ.add(s.charAt(left));
        // 开始枚举下一个字符作为起始位置
        for (; left < n; left++) {
//            System.out.println(buildDebugStart(left, s));
            if (left != 0) {
                // 左指针向右移动一格，移除 left 左边一个字符
                occ.remove(s.charAt(left - 1));
            }
            // [left,right) 不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符
            while (right < n && !occ.contains(s.charAt(right))) {
                occ.add(s.charAt(right));
//                System.out.println(buildDebugEnd(left, right, s));
                ++right;
            }
            // 第 [left, right] 个字符是一个极长的无重复字符子串
            result = Math.max(result, right - left);
        }
        return result;
    }

    private String buildDebugEnd(int left, int right, String s) {
        final StringBuffer debug = new StringBuffer("\t");
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i == left) {
                debug.append('(').append(s.charAt(left));
            } else if (i == right) {
                debug.append(s.charAt(right)).append(')');
            } else {
                debug.append(s.charAt(i));
            }
        }
        return debug.toString();
    }

    private String buildDebugStart(int left, String s) {
        final StringBuffer debug = new StringBuffer("以");
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i == left) {
                debug.append('(').append(s.charAt(left)).append(')');
            } else {
                debug.append(s.charAt(i));
            }
        }
        debug.append("开始的最长字符串为:");
        return debug.toString();
    }
}
