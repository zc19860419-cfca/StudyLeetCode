package com.study.leetCode.others;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class FourSumSolution18Test {

    private FourSumSolution18 solution;

    @Before
    public void setUp() throws Exception {
        solution = new FourSumSolution18();
    }

    @After
    public void tearDown() throws Exception {
    }

    public boolean equalList(List list1, List list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (Object object : list1) {
            if (!list2.contains(object)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void fourSum() {
//        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
//        int target = 0;
//        List<List<Integer>> ans = solution.fourSum(nums, target);
//        Assert.assertEquals(3, ans.size());
//        List<List<Integer>> expected = new ArrayList<>();
////        [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//        int[] a1 = {-2, -1, 1, 2};
//        List<int[]> ints = Arrays.asList(a1);
//
//        e1.add(-2);
//        expected.add(e1)
//        Assert.assertTrue(expected, ans);
    }
}