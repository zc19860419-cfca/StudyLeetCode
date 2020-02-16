package com.study.leetCode.divideAndConquer.generateParentheses;

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
public class GenerateParenthesesSolutionTest {

    private GenerateParenthesesSolution generateParenthesesSolution;

    @Before
    public void setUp() throws Exception {
        generateParenthesesSolution = new GenerateParenthesesSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void generateParenthesis() {
        final List<String> parenthesis = generateParenthesesSolution.generateParenthesis(3);
        System.out.println(parenthesis);
        Assert.assertEquals(5, parenthesis.size());
        Assert.assertEquals("((()))", parenthesis.get(0));
        Assert.assertEquals("(()())", parenthesis.get(1));
        Assert.assertEquals("(())()", parenthesis.get(2));
        Assert.assertEquals("()(())", parenthesis.get(3));
        Assert.assertEquals("()()()", parenthesis.get(4));

    }
}