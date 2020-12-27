package com.study.leetCode.test;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class TestProxy implements TestInterface {

    @Override
    public void doSth(TestType type) {
        doPre(type);
        switch (type){
            case A:
                final Test1 test1 = new Test1();
                test1.doSth(type);
                break;
            case B:
                final Test2 test2 = new Test2();
                test2.doSth(type);
                break;
            default:
                break;
        }

        doPost(type);

    }

    private void doPost(TestType type) {
    }

    private void doPre(TestType type) {

    }
}
