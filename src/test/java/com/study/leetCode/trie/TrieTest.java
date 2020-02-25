package com.study.leetCode.trie;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class TrieTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertFalse(trie.search("app"));
        Assert.assertTrue(trie.startsWith("app"));

        trie.insert("app");
        Assert.assertTrue(trie.search("app"));
    }

}