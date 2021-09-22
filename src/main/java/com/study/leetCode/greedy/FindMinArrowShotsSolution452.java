package com.study.leetCode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zhangchong
 * @Description: 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 * <p>
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 * Constraints:
 * <p>
 * <p>
 * 1 <= points.length <= 105
 * points[i].length == 2
 * -2^31 <= xstart < xend <= 2^31 - 1
 * <p>
 * Related Topics 贪心 数组 排序
 */
public class FindMinArrowShotsSolution452 {

    /**
     * 这个问题和区间调度算法⼀模⼀样！如果最多有  ans  个不重叠的区间，那么就⾄少需要  ans  个箭头穿透所有区间：
     *
     * @param points
     * @return
     */
    public int findMinArrowShotsSlow(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        System.out.print("[");
        for (int i = 0; i < points.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(Arrays.toString(points[i]));
        }
        System.out.println("]");
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.print("[");
        for (int i = 0; i < points.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(Arrays.toString(points[i]));
        }
        System.out.println("]");

        int n = points.length;
        //首个区间就是所有可以选择的区间中右端点最小的那个区间
        int right = points[0][1];
        //最多有几个区间不会重叠 ans
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            //找出其中与首个区间不重合并且右端点最小的区间
            if (points[i][0] > right) {
                ++ans;
                right = points[i][1];
            }
        }
        return ans;
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 1)
            return 1;
        int left, right, i, count = 1, len;
        len = points.length;
        quickSort(points, 0, len - 1);
        left = points[0][0];
        right = points[0][1];//第一个气球的左、右边界
        for (i = 1; i < len; i++) {
            left = points[i][0];
            if (right >= points[i][0]) {
                //如果产生了交集，那么就更新射箭的范围

                right = right < points[i][1] ? right : points[i][1];
            } else {
                //没有产生交
                right = points[i][1];
                count++;
            }
        }
        return count;
    }

    public void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    public int[] getPivot(int[][] points, int low, int high) {
        int mid = (low + high) / 2;
        if (points[low][0] > points[mid][0])
            swap(points, low, mid);
        if (points[low][0] > points[high][0])
            swap(points, low, high);
        if (points[mid][0] > points[high][0])
            swap(points, mid, high);
        swap(points, mid, high - 1);
        return points[high - 1];
    }

    public void quickSort(int[][] points, int low, int high) {
        if (low < high) {
            int[] pivot = getPivot(points, low, high);
            int i, j;
            i = low;
            j = high - 1;
            while (true) {
                while (i < j && points[++i][0] <= pivot[0]) ;
                while (i < j && points[--j][0] >= pivot[0]) ;
                if (i >= j)
                    break;
                swap(points, i, j);
            }
            swap(points, i, high - 1);
            quickSort(points, low, i - 1);
            quickSort(points, i + 1, high);
        }
    }
}
