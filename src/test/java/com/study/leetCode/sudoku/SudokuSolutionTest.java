package com.study.leetCode.sudoku;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class SudokuSolutionTest {

    SudokuSolution sudokuSolution;

    @Before
    public void setUp() throws Exception {
        sudokuSolution = new SudokuSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isValidSudoku() {
        char[][] board = new char[][]{
                {'5' , '3' , '.' , '.' , '7' , '.' , '.' , '.' , '.'},
                {'6' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.'},
                {'.' , '9' , '8' , '.' , '.' , '.' , '.' , '6' , '.'},
                {'8' , '.' , '.' , '.' , '6' , '.' , '.' , '.' , '3'},
                {'4' , '.' , '.' , '8' , '.' , '3' , '.' , '.' , '1'},
                {'7' , '.' , '.' , '.' , '2' , '.' , '.' , '.' , '6'},
                {'.' , '6' , '.' , '.' , '.' , '.' , '2' , '8' , '.'},
                {'.' , '.' , '.' , '4' , '1' , '9' , '.' , '.' , '5'},
                {'.' , '.' , '.' , '.' , '8' , '.' , '.' , '7' , '9'}
        };

        Assert.assertTrue(sudokuSolution.isValidSudoku(board));
    }
}