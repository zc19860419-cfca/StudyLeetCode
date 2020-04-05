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
public class PowerOfTwoSolutionTest {
    private PowerOfTwoSolution powerOfTwoSolution;

    @Before
    public void setUp() throws Exception {
        powerOfTwoSolution = new PowerOfTwoSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isPowerOfTwo() {
        Assert.assertTrue(powerOfTwoSolution.isPowerOfTwo(1));
        Assert.assertTrue(powerOfTwoSolution.isPowerOfTwo(2));
        Assert.assertTrue(powerOfTwoSolution.isPowerOfTwo(4));
        Assert.assertTrue(powerOfTwoSolution.isPowerOfTwo(8));
        Assert.assertTrue(powerOfTwoSolution.isPowerOfTwo(16));
        Assert.assertTrue(powerOfTwoSolution.isPowerOfTwo(32));
        Assert.assertTrue(powerOfTwoSolution.isPowerOfTwo(64));

        Assert.assertFalse(powerOfTwoSolution.isPowerOfTwo(3));
        Assert.assertFalse(powerOfTwoSolution.isPowerOfTwo(6));
        Assert.assertFalse(powerOfTwoSolution.isPowerOfTwo(7));
        Assert.assertFalse(powerOfTwoSolution.isPowerOfTwo(17));
        Assert.assertFalse(powerOfTwoSolution.isPowerOfTwo(31));
        Assert.assertFalse(powerOfTwoSolution.isPowerOfTwo(66));

        Assert.assertFalse(powerOfTwoSolution.isPowerOfTwo(-2147483648));
    }

    @Test
    public void test1() {
        int x = -2147483648;
        System.out.println(Integer.toBinaryString(x));

        //负数的补码=负数的反码+1
        //b = -a 在计算机内部是 b = ~a + 1 这样处理的
        //Integer.MIN_VALUE(2进制以补码形式)=1000 0000 0000 0000 0000 0000 0000 0000
        //减去1                           =0111 1111 1111 1111 1111 1111 1111 1111
        //除符号位外每一位取反               =0000 0000 0000 0000 0000 0000 0000 0000
        System.out.println(Integer.MIN_VALUE);
        //Integer.MAX_VALUE(2进制)=0111 1111 1111 1111 1111 1111 1111 1111

        System.out.println(Integer.MAX_VALUE);

        long x1 = -2147483648;
        System.out.println(Long.toBinaryString(x1));
    }
}