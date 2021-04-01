package com.study.leetCode.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class MinStackSolution155Test {

    private MinStackSolution155 solution155;

    @Before
    public void setUp() throws Exception {
        solution155 = new MinStackSolution155();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void push() {
        solution155.push(4);
    }
}