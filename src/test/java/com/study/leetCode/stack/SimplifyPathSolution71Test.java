package com.study.leetCode.stack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class SimplifyPathSolution71Test {

    private SimplifyPathSolution71 solution71;

    @Before
    public void setUp() throws Exception {
        solution71 = new SimplifyPathSolution71();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void simplifyPath1() {
        Assert.assertEquals("/c", solution71.simplifyPath("/a/./b/../../c/"));
    }

    @Test
    public void simplifyPath2() {
        Assert.assertEquals("/home/foo", solution71.simplifyPath("/home//foo/"));
    }
}