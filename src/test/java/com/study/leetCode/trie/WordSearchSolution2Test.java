package com.study.leetCode.trie;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class WordSearchSolution2Test {

    private WordSearchSolution2 wordSearchSolution;

    @Before
    public void setUp() throws Exception {
        wordSearchSolution = new WordSearchSolution2();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findWords() {
        char[][] board =new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'},
        };

        String words[] = new String[]{"oath","pea","eat","rain"};
        final List<String> found = wordSearchSolution.findWords(board, words);
        System.out.println(found);
        Assert.assertArrayEquals(new String[]{"oath", "eat"}, found.toArray(new String[found.size()]));
    }
}