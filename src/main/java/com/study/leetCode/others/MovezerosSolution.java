package com.study.leetCode.others;

/**
 * @Author: zhangchong
 * @Description: 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MovezerosSolution {

    /**
     * c(currentIndex) n(nonZeroIndex)
     * currentIndex 始终是记录当前第一个非零的元素位置
     * nonZeroIndex 始终是记录下一个非零元素要填入的位置，其实就是记录当前第一个为0的元素位置
     * 初始化时：
     * c->
     * [-----0-----][v]--------------------------------
     * n->
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            //找到非零元素 [currentIndex]
            if (nums[currentIndex] != 0) {
                //交换非零元素 [currentIndex] 到非零位置 [nonZeroIndex]： nums[currentIndex]<->nums[nonZeroIndex]
                nums[nonZeroIndex] = nums[currentIndex];
                if (currentIndex != nonZeroIndex) {
                    nums[currentIndex] = 0;
                }
                //递增 nonZeroIndex
                nonZeroIndex++;
            }

        }
    }
}
