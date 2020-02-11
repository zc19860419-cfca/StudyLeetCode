package com.study.leetCode.twoSums;

/**
 * @Author: zhangchong
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * Related Topics 数组 哈希表
 */

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class TwoSumsSolution {
    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int other;
        int otherIndex;
        for (int i = 0; i < nums.length; i++) {
            other = target - nums[i];
            otherIndex = lastIndexOf(nums, other);
            if (-1 != otherIndex && i != otherIndex) {
                return new int[]{i, otherIndex};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution!");
    }

    private int lastIndexOf(int[] elementData, int target) {
        int result = -1;
        int size = elementData.length;
        for (int i = size - 1; i >= 0; i--)
            if (target == elementData[i]) {
                result = i;
                break;
            }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

