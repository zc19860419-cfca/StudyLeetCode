package com.study.leetCode.anagram;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class AnagramSolutionTest {

    private AnagramSolution anagramSolution;

    @Before
    public void setUp() throws Exception {
        anagramSolution = new AnagramSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isAnagram1() {
        String s = "anagram", t = "nagaram";
        Assert.assertTrue(anagramSolution.isAnagram(s, t));
    }

    @Test
    public void isAnagram2() {
        String s = "rat", t = "car";
        Assert.assertFalse(anagramSolution.isAnagram(s, t));
    }

    @Test
    public void isAnagram3() {
        String s = "aa", t = "a";
        Assert.assertFalse(anagramSolution.isAnagram(s, t));
    }
}