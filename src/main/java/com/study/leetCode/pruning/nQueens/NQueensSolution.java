package com.study.leetCode.pruning.nQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
 * ch that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placem
 * ent, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * <p>
 * <p>
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as show
 * n above.
 * <p>
 * Related Topics 回溯算法
 */


//leetcode submit region begin(Prohibit modification and deletion)
class NQueensSolution {
    private int n;
    private int[] rows;
    private int[] pie;
    private int[] na;
    private int[] queens;
    private List<List<String>> output;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        pie = new int[2 * n - 1];
        na = new int[2 * n - 1];
        queens = new int[n];
        output = new ArrayList<>();

        backtrack(0, 0);
        return output;
    }

    private void placeQueen(int row, int col) {
        rows[col] = 1;
        queens[row] = col;
        pie[row + col] = 1;
        na[row - col + n - 1] = 1;
    }

    private void removeQueen(int row, int col) {
        rows[col] = 0;
        queens[row] = 0;
        pie[row + col] = 0;
        na[row - col + n - 1] = 0;
    }

    private boolean isNotUnderAttack(int row, int col) {
        return 0 == (rows[col] + pie[row + col] + na[row - col + n - 1]);
    }

    /**
     * 回溯法：从当前行开始遍历列，如果没有扫描完行，则继续递归到下一行
     *
     * @param row 当前行
     */
    private void backtrack(int row, int tab) {
        //扫描当前行的所有列
        for (int col = 0; col < n; col++) {
//            printStart(tab);
//            System.out.print("(" + row + "," + col + ")");
            if (isNotUnderAttack(row, col)) {
                //落子
                placeQueen(row, col);
//                System.out.print("->place");

                if (n - 1 == row) {
                    //如果落子落完所有行（因为一行只能落一子，故当前行如果是n-1 则落完，起始行是第0行）
//                    System.out.print("->OK");
                    addSolution();
                } else {
                    //继续DFS深入递归扫描剩余行,保证一行只落一子
                    backtrack(row + 1, tab + 1);
                }
                //恢复现场，继续扫描下一列（因为一行只能落一子，所以将该行的落子去除）
                removeQueen(row, col);
//                printStart(tab);
//                System.out.print("(" + row + "," + col + ")->unplace");
            }
        }
    }

//    private void printStart(int tab) {
//        System.out.println();
//        for (int i = 0; i < tab; i++) {
//            System.out.print('\t');
//        }
//    }

    private void addSolution() {
        List<String> rowQueen = new ArrayList<>();
        int col;
        StringBuilder builder;
        for (int row = 0; row < n; row++) {
            col = queens[row];
            builder = new StringBuilder();
            for (int i = 0; i < col ; i++) {
                builder.append(".");
            }
            builder.append("Q");
            for (int i = col + 1; i < n; i++) {
                builder.append(".");
            }
            rowQueen.add(builder.toString());
        }
        output.add(rowQueen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
