package com.study.leetCode.pruning.validSudoku;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class ValidSudokuSolutionTest {

    private ValidSudokuSolution validSudokuSolution;

    @Before
    public void setUp() throws Exception {
        validSudokuSolution = new ValidSudokuSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isValidSudoku1() {
        char[][] board = new char[9][9];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        final boolean validSudoku = validSudokuSolution.isValidSudoku(board);
        Assert.assertTrue(validSudoku);
        System.out.println(validSudokuSolution.dumpBoard());
    }

    @Test
    public void isValidSudoku2() {
        char[][] board = new char[9][9];
        board[0] = new char[]{'8','3','.','.','7','.','.','.','.'};
        board[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        board[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        board[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        board[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        board[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        board[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        board[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        board[8] = new char[]{'.','.','.','.','8','.','.','7','9'};
        final boolean validSudoku = validSudokuSolution.isValidSudoku(board);
        Assert.assertFalse(validSudoku);
    }

    @Test
    public void isValidSudoku3() {
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
        final boolean validSudoku = validSudokuSolution.isValidSudoku(board);
        Assert.assertFalse(validSudoku);
    }

    @Test
    public void isValidSudoku4() {
        char[][] board = new char[9][9];
        board[0] = new char[]{'5','.','.','.','3','9','.','6','.'};
        board[1] = new char[]{'.','.','.','.','.','.','.','9','.'};
        board[2] = new char[]{'.','.','.','5','.','8','2','.','.'};
        board[3] = new char[]{'6','.','5','8','.','.','3','.','.'};
        board[4] = new char[]{'.','9','.','.','1','.','.','2','.'};
        board[5] = new char[]{'.','.','8','.','.','3','5','.','6'};
        board[6] = new char[]{'.','.','9','7','.','6','.','.','.'};
        board[7] = new char[]{'.','2','.','.','.','.','.','.','.'};
        board[8] = new char[]{'.','5','.','9','8','.','.','.','7'};
        final boolean validSudoku = validSudokuSolution.isValidSudoku(board);
        Assert.assertTrue(validSudoku);
        Assert.assertEquals(
                "5,8,7,2,3,9,4,6,1\n" +
                "3,6,2,1,7,4,8,9,5\n" +
                "9,4,1,5,6,8,2,7,3\n" +
                "6,1,5,8,2,7,3,4,9\n" +
                "4,9,3,6,1,5,7,2,8\n" +
                "2,7,8,4,9,3,5,1,6\n" +
                "8,3,9,7,4,6,1,5,2\n" +
                "7,2,6,3,5,1,9,8,4\n" +
                "1,5,4,9,8,2,6,3,7\n",validSudokuSolution.dumpBoard());
    }

    @Test
    public void isValidSudoku5() {
        char[][] board = new char[9][9];
        board[0] = new char[]{'1','2','9','.','.','6','.','3','.'};
        board[1] = new char[]{'.','.','.','.','.','.','.','6','.'};
        board[2] = new char[]{'.','.','6','.','8','.','1','.','.'};
        board[3] = new char[]{'.','7','.','.','2','9','.','.','.'};
        board[4] = new char[]{'.','.','1','.','7','.','9','.','.'};
        board[5] = new char[]{'.','.','.','5','1','.','.','2','.'};
        board[6] = new char[]{'.','.','4','.','9','.','8','.','.'};
        board[7] = new char[]{'.','8','.','.','.','.','.','.','.'};
        board[8] = new char[]{'.','3','.','1','.','.','2','5','9'};
        final boolean validSudoku = validSudokuSolution.isValidSudoku(board);
        Assert.assertTrue(validSudoku);
        System.out.println(validSudokuSolution.dumpBoard());
        Assert.assertEquals(
                "1,2,9,4,5,6,7,3,8\n" +
                        "7,4,8,9,3,1,5,6,2\n" +
                        "3,5,6,2,8,7,1,9,4\n" +
                        "4,7,5,6,2,9,3,8,1\n" +
                        "2,6,1,8,7,3,9,4,5\n" +
                        "8,9,3,5,1,4,6,2,7\n" +
                        "5,1,4,3,9,2,8,7,6\n" +
                        "9,8,2,7,6,5,4,1,3\n" +
                        "6,3,7,1,4,8,2,5,9\n",validSudokuSolution.dumpBoard());
    }

    @Test
    public void isValidSudoku6() {
        char[][] board = new char[9][9];
        board[0] = new char[]{'.','8','.','.','9','.','5','.','.'};
        board[1] = new char[]{'.','.','5','.','.','8','7','.','.'};
        board[2] = new char[]{'.','3','7','5','4','.','.','.','6'};
        board[3] = new char[]{'.','7','.','.','5','.','2','.','.'};
        board[4] = new char[]{'.','.','.','.','3','.','.','.','.'};
        board[5] = new char[]{'.','.','4','.','7','.','.','1','.'};
        board[6] = new char[]{'3','.','.','.','8','7','1','2','.'};
        board[7] = new char[]{'.','.','8','4','.','.','9','.','.'};
        board[8] = new char[]{'.','.','9','.','2','.','.','5','.'};
        final boolean validSudoku = validSudokuSolution.isValidSudoku(board);
        Assert.assertTrue(validSudoku);
        System.out.println(validSudokuSolution.dumpBoard());
        Assert.assertEquals(
                "6,8,2,7,9,3,5,4,1\n" +
                        "4,9,5,6,1,8,7,3,2\n" +
                        "1,3,7,5,4,2,8,9,6\n" +
                        "8,7,3,1,5,4,2,6,9\n" +
                        "5,6,1,2,3,9,4,8,7\n" +
                        "9,2,4,8,7,6,3,1,5\n" +
                        "3,5,6,9,8,7,1,2,4\n" +
                        "2,1,8,4,6,5,9,7,3\n" +
                        "7,4,9,3,2,1,6,5,8\n",validSudokuSolution.dumpBoard());
    }

    @Test
    public void isValidSudoku7() {
        char[][] board = new char[9][9];
        board[0] = new char[]{'1','.','.','.','.','.','.','.','9'};
        board[1] = new char[]{'.','6','.','.','.','3','4','.','.'};
        board[2] = new char[]{'.','2','.','.','9','.','.','8','7'};
        board[3] = new char[]{'.','.','.','5','1','.','6','.','3'};
        board[4] = new char[]{'.','.','.','.','.','.','.','.','.'};
        board[5] = new char[]{'3','.','7','.','2','9','.','.','.'};
        board[6] = new char[]{'2','7','.','.','5','.','.','1','.'};
        board[7] = new char[]{'.','.','8','4','.','.','.','7','.'};
        board[8] = new char[]{'5','.','.','.','.','.','.','.','4'};
        final boolean validSudoku = validSudokuSolution.isValidSudoku(board);
        Assert.assertTrue(validSudoku);
        System.out.println(validSudokuSolution.dumpBoard());
        Assert.assertEquals(
                "1,8,3,7,4,5,2,6,9\n" +
                        "7,6,9,2,8,3,4,5,1\n" +
                        "4,2,5,1,9,6,3,8,7\n" +
                        "8,4,2,5,1,7,6,9,3\n" +
                        "6,9,1,8,3,4,7,2,5\n" +
                        "3,5,7,6,2,9,1,4,8\n" +
                        "2,7,4,3,5,8,9,1,6\n" +
                        "9,3,8,4,6,1,5,7,2\n" +
                        "5,1,6,9,7,2,8,3,4\n",validSudokuSolution.dumpBoard());
    }
}