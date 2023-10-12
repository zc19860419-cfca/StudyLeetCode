package com.study.leetCode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchong
 * @Description Node 邻接表形式的图形结构
 * @CodeReviewer qazhang
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Node node = (Node) o;
//
//        if (val != node.val) return false;
//        return neighbors != null ? neighbors.equals(node.neighbors) : node.neighbors == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = val;
//        result = 31 * result + (neighbors != null ? neighbors.hashCode() : 0);
//        return result;
//    }
}
