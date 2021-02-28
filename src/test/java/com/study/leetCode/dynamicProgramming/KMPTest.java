package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class KMPTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void search1() {
        final KMP kmp = new KMP("ababa");
        Assert.assertEquals(2, kmp.search("ccababacc"));
    }

    @Test
    public void search2() {
        final KMP kmp = new KMP("abababca");
        Assert.assertEquals(2, kmp.search("ccabababca"));
    }


}