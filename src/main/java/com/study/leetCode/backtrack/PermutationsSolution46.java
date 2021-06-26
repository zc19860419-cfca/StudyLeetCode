package com.study.leetCode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhangchong
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * @Description: Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * <p>
 * Related Topics 数组 回溯
 */
public class PermutationsSolution46 {
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        DictionaryPermutationsGenerator generator = new DictionaryPermutationsGenerator(nums);
        res.add(Arrays.stream(generator.data).boxed().collect(Collectors.toList()));
        List<Integer> next;
        while (true) {
            next = generator.next();
            if (next == null) {
                break;
            }
            res.add(next);
        }
        return res;
    }

    class DictionaryPermutationsGenerator {
        private final int[] data;
        private final int n;
        private boolean end = false;

        DictionaryPermutationsGenerator(int[] data) {
            this.data = data;
            this.n = data.length;
            if (n == 1) {
                this.end = true;
            }
            if (n > 2) {
                Arrays.sort(this.data);
            }
        }

        public List<Integer> next() {
            if (end) {
                return null;
            }
            if (n <= 2) {
                swap(data, 0, 1);
                end = true;
            } else {
                int j = n - 2;
                while (data[j] >= data[j + 1]) {
                    j = j - 1;
                    if (j == -1) {
                        break;
                    }
                }
                //  找到第一个升序相邻对 data[j] < data[j + 1]，从而得知右侧的所有相邻对都是降序 data[j + 1] 是峰值

                if (j <= -1) {
                    end = true;
                    return null;
                }
                int nMinus1 = n - 1;
                int l = nMinus1;
                while (data[j] >= data[l]) {
                    l = l - 1;
                }
//              data[n-1] <= ... <= data[l+1] <= data[j] < data[l] <= data[l-1] <= ... <=data[j+1]
                swap(data, j, l);
//              data[n-1] <= ... <= data[l+1] <= data[l] < data[j] <= data[l-1] <= ... <=data[j+1]
                int k = j + 1;
                l = nMinus1;
                while (k < l) {
                    swap(data, k, l);
                    k = k + 1;
                    l = l - 1;
                }
                //k>=l
            }
            return Arrays.stream(data).boxed().collect(Collectors.toList());
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int index) {
        if (index >= nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                cur.add(nums[i]);
            }
            res.add(cur);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(nums, res, index + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 这样交换会报错！！！
     * @param array
     * @param j
     * @param l
     */
//    private void swap(int[] array, int j, int l) {
//        array[j] ^= array[l];
//        array[l] ^= array[j];
//        array[j] ^= array[l];
//    }
}
