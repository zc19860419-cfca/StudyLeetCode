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
public class HasAlternatingBitsSolution693Test {

    private HasAlternatingBitsSolution693 solution693;

    @Before
    public void setUp() throws Exception {
        solution693 = new HasAlternatingBitsSolution693();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hasAlternatingBits() {
        Assert.assertTrue(solution693.hasAlternatingBits(5));
        Assert.assertFalse(solution693.hasAlternatingBits(7));
        Assert.assertFalse(solution693.hasAlternatingBits(11));
        Assert.assertTrue(solution693.hasAlternatingBits(10));
        Assert.assertFalse(solution693.hasAlternatingBits(3));
    }
}