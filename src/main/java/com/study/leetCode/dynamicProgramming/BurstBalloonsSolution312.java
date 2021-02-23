package com.study.leetCode.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: zhangchong
 * @Description:
 */
public class BurstBalloonsSolution312 {
//    private int result = Integer.MIN_VALUE;
//    public int maxCoins(int[] nums) {
//        int n = nums.length;
//        List<Integer> val = new ArrayList<>(n + 2);
//        for (int i = 0; i < n + 2; i++) {
//            val.add(Integer.MIN_VALUE);
//        }
//        for (int i = 1; i <= n; i++) {
//            val.set(i, nums[i - 1]);
//        }
//        val.set(0, 1);
//        val.set(n + 1, 1);
//
//        backtrace(val, 0);
//        return result;
//    }
//
//    private void backtrace(List<Integer> val, int score) {
//        if (val.size() == 2) {
//            result = Math.max(result, score);
//            return;
//        }
//
//        for (int i = 1; i < val.size() - 1; i++) {
//            int point = val.get(i - 1) * val.get(i) * val.get(i + 1);
//
//            int temp = val.get(i);
//
//            //选择戳 第 i 个 气球
//            //在 val 中删除元素 val[i]
//            val.remove(i);
//            //递归回溯
////            System.out.println("Burst["+i+"]="+temp+":"+(score + point));
//            backtrace(val, score + point);
//
//            //撤销选择
//            //将 temp 还原到 val[i]
//            val.add(i, temp);
//        }
//    }

    public int[][] rec;
    public int[] val;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        return solve(0, n + 1);
    }

    public int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }
}
