package com.study.leetCode.bitOperation.bitmap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class HammingWeightSolutionTest {

    private HammingWeightSolution hammingWeightSolution;

    @Before
    public void setUp() throws Exception {
        hammingWeightSolution = new HammingWeightSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hammingWeight() {
        final int hammingWeight = hammingWeightSolution.hammingWeight(32);
        Assert.assertEquals(1, hammingWeight);

    }
}