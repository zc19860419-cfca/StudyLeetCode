package com.study.leetCode.trie;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class WordSearchSolutionTest {

    private WordSearchSolution wordSearchSolution;

    @Before
    public void setUp() throws Exception {
        wordSearchSolution = new WordSearchSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void exist1() {
        char[][] board =new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        String word = "ABCCED";
        Assert.assertTrue(wordSearchSolution.exist(board, word));

        word = "SEE";
        Assert.assertTrue(wordSearchSolution.exist(board, word));

        word = "ABCB";
        Assert.assertFalse(wordSearchSolution.exist(board, word));
    }

    @Test
    public void exist2() {
        char[][] board =new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        String word = "ABCB";
        Assert.assertFalse(wordSearchSolution.exist(board, word));
    }
}