package com.study.leetCode.topologicalSort;

import com.study.leetCode.topologicalSort.WordSortSolution.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class WordSortSolutionTest {

    WordSortSolution sortSolution;

    @Before
    public void setUp() throws Exception {
        sortSolution = new WordSortSolution();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void wordSort() {
        final Item w = new Item();
        w.c = 'w';
        final Item e = new Item();
        e.c = 'e';
        final Item r = new Item();
        r.c = 'r';
        final Item t = new Item();
        t.c = 't';
        final Item f = new Item();
        f.c = 'f';
        Item[][] prerequisites = new Item[][]{
                {e, r}, {w, e}, {w, r},
                {t, f}, {r, t}, {r, f},
        };
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        prerequisites = sortSolution.build(words);
        sortSolution.initLetterTable(prerequisites);
        System.out.println(sortSolution.wordSort(5, prerequisites));
    }
}