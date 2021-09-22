package com.study.leetCode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zhangchong
 * @Description: 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * Related Topics 贪心算法
 */
public class EraseOverlapIntervalsSolution435 {
    /**
     * 贪心算法
     * 假设在某一种最优的选择方法中，[l_k, r_k]是首个（即最左侧的）区间，那么它的左侧没有其它区间，右侧有若干个不重叠的区间。
     * 设想一下，如果此时存在一个区间 [l_j, r_j]，使得 r_j < r_k，即区间 j 的右端点在区间 k 的左侧，
     * 那么我们将区间 k 替换为区间 j，其与剩余右侧被选择的区间仍然是不重叠的。而当我们将区间 k 替换为区间 j 后，就得到了另一种最优的选择方法。
     * <p>
     * 那么首先求得最多有几个区间不会重叠 ans,那么剩下的不就是⾄少需要去除的区间吗？
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(Arrays.toString(intervals[i]));
        }
        System.out.println("]");
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                if (interval1[1] > interval2[1]) {
                    return 1;
                } else if (interval1[1] < interval2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(Arrays.toString(intervals[i]));
        }
        System.out.println("]");

        int n = intervals.length;
        //首个区间就是所有可以选择的区间中右端点最小的那个区间
        int right = intervals[0][1];
        //最多有几个区间不会重叠 ans
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            //找出其中与首个区间不重合并且右端点最小的区间
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }


    public int eraseOverlapIntervalsDp(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(Arrays.toString(intervals[i]));
        }
        System.out.println("]");

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(Arrays.toString(intervals[i]));
        }
        System.out.println("]");

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(f));
        return n - Arrays.stream(f).max().getAsInt();
    }
}
