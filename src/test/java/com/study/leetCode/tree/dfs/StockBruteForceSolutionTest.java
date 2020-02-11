package com.study.leetCode.tree.dfs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class StockBruteForceSolutionTest {

    private StockBruteForceSolution bruteForceSolution;

    @Before
    public void setUp() throws Exception {
        bruteForceSolution = new StockBruteForceSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxProfit() {
        final int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(bruteForceSolution.maxProfit(prices));
    }
}