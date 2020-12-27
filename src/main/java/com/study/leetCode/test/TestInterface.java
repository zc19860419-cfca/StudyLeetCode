package com.study.leetCode.test;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public interface TestInterface {
    enum TestType{
        A,B;
    }

    void doSth(TestType type);
}
