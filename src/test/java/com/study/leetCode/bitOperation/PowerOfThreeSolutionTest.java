package com.study.leetCode.bitOperation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class PowerOfThreeSolutionTest {

    private PowerOfThreeSolution powerOfThreeSolution;

    @Before
    public void setUp() throws Exception {
        powerOfThreeSolution = new PowerOfThreeSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isPowerOfThree() {
        Assert.assertTrue(powerOfThreeSolution.isPowerOfThree(1));
        Assert.assertTrue(powerOfThreeSolution.isPowerOfThree(3));
        Assert.assertTrue(powerOfThreeSolution.isPowerOfThree(9));

        Assert.assertFalse(powerOfThreeSolution.isPowerOfThree(45));
    }
}