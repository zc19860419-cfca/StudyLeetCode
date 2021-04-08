package com.study.leetCode.others;

/**
 * @Author: zhangchong
 * @Description: 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * Related Topics 字符串
 */
public class LongestCommonPrefixSolution14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder;
        if (strs.length == 1) {
            builder = new StringBuilder(strs[0]);
        } else if (strs.length > 1) {
            builder = new StringBuilder();
            int minlength = Integer.MAX_VALUE;
            for (String str : strs) {
                minlength = Math.min(str.length(), minlength);
            }

            int i = 0;
            boolean diff = false;
            for (; i < minlength; i++) {
                for (int j = 0; j < strs.length; j++) {
                    if (j > 0 && strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                        diff = true;
                        break;
                    }
                }
                if (!diff) {
                    builder.append(strs[0].charAt(i));
                }
            }
        } else {
            builder = new StringBuilder();
        }

        return builder.toString();
    }

    public String longestCommonPrefixFinal(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
