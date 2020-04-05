package com.study.leetCode.dynamicProgramming;

import java.util.List;

/**
 * @Author: zhangchong
 * @Description: 120. 三角形最小路径和
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * <p>
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * <p>
 * Bonus point if you are able to do this using only O(n) extra space, where n i
 * s the total number of rows in the triangle.
 * Related Topics 数组 动态规划
 */


//leetcode submit region begin(Prohibit modification and deletion)
public class MinimumTotalSolution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int minimumTotal = 0;
        if (null == triangle || triangle.isEmpty()) {
            minimumTotal = 0;
        } else {
            int M = triangle.size();
            int N = triangle.get(M - 1).size();
            int[] min = new int[N];
            for (int j = 0; j < N; j++) {
                min[j] = triangle.get(M - 1).get(j);
            }

            int range;
            for (int i = M - 2; i >= 0; i--) {
                range = triangle.get(i).size();
                for (int j = 0; j < range; j++) {
                    //min 不需要申请二维数组，因为只需要跟相邻的下一层有关，跟其他层无关了，所以一维覆盖就好了
                    //状态压缩
                    min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
                }
            }
            minimumTotal = min[0];
        }
        return minimumTotal;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
