package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: 931. 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：下面是两条和最小的下降路径，用加粗标注：
 * [[2,1,3],      [[2,1,3],
 * [6,5,4],       [6,5,4],
 * [7,8,9]]       [7,8,9]]
 * 示例 2：
 * <p>
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：下面是一条和最小的下降路径，用加粗标注：
 * [[-19,57],
 * [-40,-5]]
 * 示例 3：
 * <p>
 * 输入：matrix = [[-48]]
 * 输出：-48
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */
public class MinFallingPathSumSolution931 {
    // 备忘录
    private int[][] memory;

    public int minFallingPathSum(int[][] matrix) {
        final int n = matrix.length;
        int result = Integer.MAX_VALUE;
        // 备忘录里的值初始化为 66666
        memory = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memory[i][j] = 66666;
            }
        }

        // 终点可能在最后一行的任意一列
        for (int j = 0; j < n; j++) {
            result = Math.min(result, dp(matrix, n - 1, j));
        }
        return result;
    }

    /**
     * dp(matrix, i, j) 含义是 从第一行 matrix[0][...]落到 matrix[i][j] 的最小路径和
     * dp(matrix, i, j) = matrix[i][j]+ min{
     * dp(matrix, i-1, j-1),
     * dp(matrix, i-1, j),
     * dp(matrix, i-1, j+1)
     * }
     * <p>
     * 开启备忘录
     *
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    private int dp(int[][] matrix, int row, int col) {
        //1、索引合法性检查
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return 99999;
        }

        //2、base case
        if (row == 0) {
            return matrix[0][col];
        }

        //3、检查备忘录
        if (memory[row][col] != 66666) {
            return memory[row][col];
        }

        //状态转移
        memory[row][col] = matrix[row][col] + min(
                dp(matrix, row - 1, col - 1),
                dp(matrix, row - 1, col),
                dp(matrix, row - 1, col + 1)
        );
        return memory[row][col];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
