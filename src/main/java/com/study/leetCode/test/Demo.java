package com.study.leetCode.test;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class Demo {

    public static void main(String[] args) {
        TestInterface testInterface = new TestProxy();
        testInterface.doSth(TestInterface.TestType.A);

    }
}
