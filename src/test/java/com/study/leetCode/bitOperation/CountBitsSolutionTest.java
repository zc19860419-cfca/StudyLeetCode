package com.study.leetCode.bitOperation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class CountBitsSolutionTest {

    private CountBitsSolution countBitsSolution;

    @Before
    public void setUp() throws Exception {
        countBitsSolution = new CountBitsSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void countBits() {
        final int[] actuals = countBitsSolution.countBits(2);
        final int[] expecteds = new int[]{0, 1, 1};
        Assert.assertArrayEquals(expecteds, actuals);
    }
}