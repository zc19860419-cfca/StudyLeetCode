package com.study.leetCode.pruning.validSudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description 36. Valid Sudoku
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be val
 * idated according to the following rules:
 * <p>
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without r
 * epetition.
 * <p>
 * <p>
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * <p>
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is
 * invalid.
 * <p>
 * <p>
 * Note:
 * <p>
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solva
 * ble.
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 * <p>
 * Related Topics 哈希表
 */


//leetcode submit region begin(Prohibit modification and deletion)
class ValidSudokuSolution {
    private Set<Integer>[] rows;
    private Set<Integer>[] cols;
    private Set<Integer>[][] block;
    private boolean[][] placement;
    private char[][] board;
    private boolean sudokuSolved;

    // block size
    private static int BLOCK_SIZE = 3;

    // row size
    private static int ROW_SIZE = BLOCK_SIZE * BLOCK_SIZE;

    ValidSudokuSolution() {
        placement = new boolean[ROW_SIZE][ROW_SIZE];
        board = new char[ROW_SIZE][ROW_SIZE];
        rows = new Set[ROW_SIZE];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new HashSet<>();
        }

        cols = new Set[ROW_SIZE];
        for (int i = 0; i < cols.length; i++) {
            cols[i] = new HashSet<>();
        }
        block = new Set[BLOCK_SIZE][BLOCK_SIZE];
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                block[i][j] = new HashSet<>();
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        prepareBoard();
        solveSudokuWithNativeDFS(0, 0);
        return sudokuSolved;
    }

    private void prepareBoard() {
        char c;
        int value;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                c = board[row][col];
                if ('.' != c) {
                    value = Character.getNumericValue(c);
                    placement[row][col] = true;
                    placeNumber(row, col, value);
                }
            }
        }
    }

    private void dumpCheckResult() {
        dumpRows();
        dumpCols();
        dumpBlocks();
    }

    public String dumpBoard() {
        StringBuilder builder = new StringBuilder();
        if (sudokuSolved){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (j > 0) {
                        builder.append(',');
                    }
                    builder.append(board[i][j]);
                }
                builder.append('\n');
            }
        }
        return builder.toString();
    }

    private void dumpBlocks() {
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                if (j > 0) {
                    System.out.print(",");
                }
                System.out.print(block[i][j]);
            }
            System.out.println();
        }
    }

    private void dumpCols() {
        for (int i = 0; i < cols.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(cols[i]);
        }
        System.out.println();
    }

    private void dumpRows() {
        for (int i = 0; i < rows.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(rows[i]);
        }
        System.out.println();
    }

    /**
     * 朴素DFS 解决数独问题
     *
     * @param row
     * @param col
     */
    private void solveSudokuWithNativeDFS(int row, int col) {
        boolean isValid;
        //终止条件：到达最后一个格子
        if (col == ROW_SIZE && row == ROW_SIZE - 1) {
            sudokuSolved = true;
        } else {
            if (col == ROW_SIZE) {
                //去下一行，重新扫描列
                solveSudokuWithNativeDFS(row + 1, 0);
            } else {
                if (placement[row][col]) {
                    //继续扫描下一列
                    solveSudokuWithNativeDFS(row, col + 1);
                } else {
                    for (int candidateNum = 1; candidateNum <= 9; candidateNum++) {
                        if (checkValid(row, col, candidateNum)) {
                            placeNumber(row, col, candidateNum);
                            solveSudokuWithNativeDFS(row, col + 1);
                            if (!sudokuSolved) {
                                //一旦解决了，就应该终止了
                                removeNumber(row, col, candidateNum);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean checkValid(int row, int col, int placement) {
        return (!rows[row].contains(placement) && !cols[col].contains(placement) && !block[row / BLOCK_SIZE][col / BLOCK_SIZE].contains(placement));
    }

    private void removeNumber(int row, int col, int placement) {
        rows[row].remove(placement);
        cols[col].remove(placement);
        block[row / BLOCK_SIZE][col / BLOCK_SIZE].remove(placement);
        board[row][col] = '.';
    }

    private void placeNumber(int row, int col, int placement) {
        rows[row].add(placement);
        cols[col].add(placement);
        block[row / BLOCK_SIZE][col / BLOCK_SIZE].add(placement);
        board[row][col] = (char) (placement + '0');
    }
}
//leetcode submit region end(Prohibit modification and deletion)

