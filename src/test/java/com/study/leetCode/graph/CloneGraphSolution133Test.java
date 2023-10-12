package com.study.leetCode.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchong
 * @Description CloneGraphSolution133Test
 * @CodeReviewer qazhang
 */
public class CloneGraphSolution133Test {

    private CloneGraphSolution133 solution133;

    @Before
    public void setUp() throws Exception {
        solution133 = new CloneGraphSolution133();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void cloneGraph() {
//        [[2,4],[1,3],[2,4],[1,3]]
        List<List<Integer>> adjList = new ArrayList<>();
        final List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(4);
        final List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(3);
        final List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(4);
        final List<Integer> l4 = new ArrayList<>();
        l4.add(1);
        l4.add(3);
        adjList.add(l1);
        adjList.add(l2);
        adjList.add(l3);
        adjList.add(l4);
        Node header = solution133.buildGraph(adjList);

//        final Node node = solution133.cloneGraph(header);
//        debugScan(node);
    }




}