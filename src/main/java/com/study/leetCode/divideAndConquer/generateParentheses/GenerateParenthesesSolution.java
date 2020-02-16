package com.study.leetCode.divideAndConquer.generateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of
 * well-formed parentheses.
 * <p>
 * <p>
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * Related Topics 字符串 回溯算法
 * 我们的复杂度分析依赖于理解 generateParenthesis(n) 中有多少个元素。这个分析超出了本文的范畴，但事实证明这是第 n 个卡塔兰数
 * 矩阵连乘： P=a1×a2×a3×……×an，依据乘法结合律，不改变其顺序，只用括号表示成对的乘积，试问有几种括号化的方案？(h(n)种)
 */


//leetcode submit region begin(Prohibit modification and deletion)
class GenerateParenthesesSolution {
    public List<String> generateParenthesis(int n) {
        final RecGenerator generator = new RecGenerator();
        return generator.generate(0, 0, n, "");
    }

    private static class RecGenerator {

        /**
         * @param left
         * @param right
         * @param n
         * @return
         */
        public List<String> generate(int left, int right, int n, String result) {
            List<String> parentheses = new ArrayList<>();
            if (n == left && n == right) {
                parentheses.add(result);
            } else {
                if (left < n) {
                    parentheses.addAll(generate(left + 1, right, n, result + "("));
                }
                if (right < n && right < left) {
                    parentheses.addAll(generate(left, right + 1, n, result + ")"));
                }
            }
            return parentheses;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

