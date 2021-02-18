package com.study.leetCode.others;

/**
 * @Author: zhangchong
 * @Description: 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class isPalindromeSolution125 {
    public boolean isPalindrome(String s) {
        String filtered = filterNonNumberAndChar(s);
        String reversed = reverseString(filtered);
        return reversed.equalsIgnoreCase(filtered);
    }

    private String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String filterNonNumberAndChar(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "");
    }

    public boolean isPalindromeMostVoted(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while (head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}


