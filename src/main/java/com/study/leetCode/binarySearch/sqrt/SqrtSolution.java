package com.study.leetCode.binarySearch.sqrt;

import cfca.org.slf4j.Logger;
import cfca.org.slf4j.LoggerFactory;

/**
 * @Author: zhangchong
 * @Description: Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-ne
 * gative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and onl
 * y the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: 4
 * Output: 2
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 * <p>
 * Related Topics 数学 二分查找
 */


//leetcode submit region begin(Prohibit modification and deletion)
public class SqrtSolution {

    private Logger LOG = LoggerFactory.getLogger(SqrtSolution.class);

    public int mySqrt1(int x) {
        int result = 0;
        if (0 == x || 1 == x) {
            result = x;
        } else {
            int left = 0;
            int right = x;
            int mid;
            while (left <= right) {
                mid = left + ((right - left) >> 1);
                LOG.info("({},{})->{}", left, right, mid);
                if (mid == x / mid) {
                    result = mid;
                    break;
                }
                if (mid < x / mid) {
                    left = mid + 1;
                    result = mid;
                } else {
                    right = mid - 1;
                }

            }
        }
        return result;
    }

    /**
     * 牛顿迭代法 xn+1 = xn-f(xn)/f'(xn)
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int xn;
        if (0 == x || 1 == x) {
            xn = x;
        } else if (x >= 2147395600) {
            xn = 46340;
        } else {
            xn = x;
            while (xn > x / xn) {
                xn = x / xn + ((xn - x / xn) >> 1);
            }
        }
        return xn;
    }

    /**
     * hack
     * https://www.beyond3d.com/content/articles/8
     *
     * @param x
     * @return
     */
    public double mySqrt3(int x) {
        return 1 / InvSqrt(x);
    }

    /**
     * 1/Sqrt(x)
     *
     * @param x
     * @return
     */
    float InvSqrt(float x) {
        float xhalf = 0.5f * x;
        int i = (int) x;
        i = 0x5f3759df - (i >> 1);
        x = (float) i;
        x = x * (1.5f - xhalf * x * x);
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

