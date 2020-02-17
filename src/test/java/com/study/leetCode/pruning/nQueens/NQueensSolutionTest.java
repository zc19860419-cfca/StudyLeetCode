package com.study.leetCode.pruning.nQueens;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class NQueensSolutionTest {

    private NQueensSolution nQueensSolution;

    @Before
    public void setUp() throws Exception {
        nQueensSolution = new NQueensSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void solveNQueens1() {
        final List<List<String>> solveNQueens = nQueensSolution.solveNQueens(4);
        Assert.assertEquals(2, solveNQueens.size());
        final List<String> solution = solveNQueens.get(0);
        Assert.assertEquals("[.Q.., ...Q, Q..., ..Q.]",solveNQueens.get(0).toString());
        Assert.assertEquals("[..Q., Q..., ...Q, .Q..]",solveNQueens.get(1).toString());
    }
}