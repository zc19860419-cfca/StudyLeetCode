package com.study.leetCode.topologicalSort;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class CourseScheduleSolutionTest {

    private CourseScheduleSolution courseScheduleSolution;

    @Before
    public void setUp() throws Exception {
        courseScheduleSolution = new CourseScheduleSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void canFinish() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        Assert.assertFalse(courseScheduleSolution.canFinish(numCourses, prerequisites));
    }

    @Test
    public void canFinish1() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        Assert.assertTrue(courseScheduleSolution.canFinish(numCourses, prerequisites));
    }
}