package com.study.leetCode.bitOperation;

/**
 * @Author: zhangchong
 * @Description:
 */
public class HasAlternatingBitsSolution693 {
    public boolean hasAlternatingBits(int n) {
        int last;
        int lastOfRemain;
        boolean hasAlternatingBits = true;
        while (n > 1) {
            last = n % 2;
            n = n >> 1;
            lastOfRemain = n % 2;
            if (last == lastOfRemain) {
                hasAlternatingBits = false;
            }
        }
        return hasAlternatingBits;
    }
}
