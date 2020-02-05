package com.study.leetCode.anagram;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangchong
 * @Description: Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your soluti
 * on to such case?
 * Related Topics 排序 哈希表
 */
//leetcode submit region begin(Prohibit modification and deletion)
class AnagramSolution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sCharCountMap = new HashMap<>();
        Map<Character, Integer> tCharCountMap = new HashMap<>();
        char c;
        int count;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (sCharCountMap.containsKey(c)) {
                count = sCharCountMap.get(c);
                sCharCountMap.put(c, ++count);
            } else {
                sCharCountMap.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if (tCharCountMap.containsKey(c)) {
                count = tCharCountMap.get(c);
                tCharCountMap.put(c, ++count);
            } else {
                tCharCountMap.put(c, 1);
            }
        }

        return sCharCountMap.equals(tCharCountMap);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

