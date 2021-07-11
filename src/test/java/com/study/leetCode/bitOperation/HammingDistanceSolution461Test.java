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
public class HammingDistanceSolution461Test {

    private HammingDistanceSolution461 solution461;

    @Before
    public void setUp() throws Exception {
        solution461 = new HammingDistanceSolution461();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hammingDistance() {
        Assert.assertEquals(2, solution461.hammingDistance(1, 4));
        Assert.assertEquals(1, solution461.hammingDistance(3, 1));
    }

}