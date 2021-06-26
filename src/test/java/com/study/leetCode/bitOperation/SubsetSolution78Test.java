package com.study.leetCode.bitOperation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class SubsetSolution78Test {

    private SubsetSolution78 solution78;

    @Before
    public void setUp() throws Exception {
        solution78 = new SubsetSolution78();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void subsets() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution78.subsets(nums));
    }
}