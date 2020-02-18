package com.study.leetCode.pruning.validSudoku;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class SudokuSolutionTest {

    private SudokuSolution sudokuSolution;

    @Before
    public void setUp() throws Exception {
        sudokuSolution = new SudokuSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void solveSudoku() {
        char[][] board = new char[9][9];
        board[0] = new char[]{'.','8','7','6','5','4','3','2','1'};
        board[1] = new char[]{'2','.','.','.','.','.','.','.','.'};
        board[2] = new char[]{'3','.','.','.','.','.','.','.','.'};
        board[3] = new char[]{'4','.','.','.','.','.','.','.','.'};
        board[4] = new char[]{'5','.','.','.','.','.','.','.','.'};
        board[5] = new char[]{'6','.','.','.','.','.','.','.','.'};
        board[6] = new char[]{'7','.','.','.','.','.','.','.','.'};
        board[7] = new char[]{'8','.','.','.','.','.','.','.','.'};
        board[8] = new char[]{'9','.','.','.','.','.','.','.','.'};
        sudokuSolution.solveSudoku(board);
        System.out.println(sudokuSolution.sudokuSolved);
        sudokuSolution.dumpBoard();

    }
}