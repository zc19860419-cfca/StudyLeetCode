package com.study.leetCode.binarySearch;

/**
 * @Author: zhangchong
 * @Description:1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * 条件限制:
 * <p>
 * 1 <= days <= weights.length <= 5 * 10^4
 * 1 <= weights[i] <= 500
 * <p>
 * Related Topics 数组 二分查找
 */
public class ShipWithinDaysSolution1011 {
    public int shipWithinDays(int[] weights, int days) {
        //先定船的最低运载能力的上下界
        //船的运载能力的下界是是根据包裹元素的最大值
        //船的运载能力的上界是所有包裹之和
        int low = 0;
        int high = 0;
        for (int weight : weights) {
            high += weight;
            if (weight > low) {
                low = weight;
            }
        }

        //二分搜索
        int mid;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            System.out.println("[" + low + "," + high + "]:" + mid);
            if (possible(weights, mid, days)) {
                //减少需要的天数
                high = mid;
            } else {
                //增加需要的天数
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 贪心模拟运包裹
     * 假设按照 船的指定运载能力 cap，是否能在 d 天内运完
     * 每次一段的和一旦大于 cap，将该节点作为新的分割段的起始部分
     *
     * @param weights
     * @param cap
     * @param d
     * @return
     */
    private boolean possible(int[] weights, int cap, int d) {
        int days = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > cap) {
                //超过一天的运量，换一天继续运
                sum = weight;
                days++;
            } else {
                sum += weight;
            }
        }
        return days <= d;
    }

    public int shipWithinDays1(int[] weights, int days) {
        //先定船的最低运载能力的上下界
        //船的运载能力的下界是是根据包裹元素的最大值
        //船的运载能力的上界是
        // 优化：假设每一堆都是最大值，总量 max * weights.length
        // 在指定 days 内运完 所计算出来的运载能力就是上界
        int low = -1;
        for (int weight : weights) {
            if (weight > low) {
                low = weight;
            }
        }
        int high = low * weights.length / days + 1;
        System.out.println("[" + low + "," + high + "]");
        //二分搜索
        int mid;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            System.out.println("[" + low + "," + high + "]:" + mid);
            if (possible(weights, mid, days)) {
                //减少需要的天数
                high = mid;
            } else {
                //增加需要的天数
                low = mid + 1;
            }
        }
        return low;
    }

    public int shipWithinDays2(int[] weights, int D) {
        // 载重范围，最小应该是货物中最大重量（否则就没办法装船了）
        int left = 0;
        for (int weight : weights) {
            if (weight > left) {
                left = weight;
            }
        }
        // 最大应该是假设每个货物都为最大，平均每天能带多少
        // 注：当D > weights.length 时, right < left 即 此时会直接返回 left。而背后的逻辑是，当天数大于货物数量，那么只要每天至少搬一个货物上船即可，此时可以达到区间的最小，即货物的最大重量
        int right = left * weights.length / D + 1;
        System.out.println("[" + left + "," + right + "]");
        // 取值区间使用左右闭合
        while (left <= right) {
            int mid = (left + right) >>> 1;
            System.out.println("[" + left + "," + right + "]:" + mid);
            if (canFinish(weights, D, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] weights, int D, int cap) {
        int day = 1, cur = cap;
        for (int weight : weights) {
            if (weight > cur) {
                day++;
                cur = cap;
            }
            cur -= weight;
        }
        return day <= D;
    }
}
