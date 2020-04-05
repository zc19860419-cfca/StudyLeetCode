package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description:338. 比特位计数
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return th
 * em as an array.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: 2
 * Output: [0,1,1]
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * <p>
 * <p>
 * Follow up:
 * <p>
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer))
 * . But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __bu
 * iltin_popcount in c++ or in any other language.
 * Related Topics 位运算 动态规划
 */

//leetcode submit region begin(Prohibit modification and deletion)
public class CountBitsSolution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            //位运算来做下标
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

