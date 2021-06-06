package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class PartitionPalindromeSolution131Test {

    private PartitionPalindromeSolution131 solution;

    @Before
    public void setUp() throws Exception {
        solution = new PartitionPalindromeSolution131();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void partition() {
        System.out.println(solution.partition("aab"));
    }
}