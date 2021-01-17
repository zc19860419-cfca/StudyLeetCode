package com.study.leetCode.disjointSet;

/**
 * @Author: zhangchong
 * @Description: 并查集实现：
 * 带有路径压缩
 * 带启发式合并
 */
public class QuickUnionUF {
    private int count;
    private int[] parent;
    private int[] rank;

    public QuickUnionUF(int total) {
        parent = new int[total];
        for (int i = 0; i < total; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(i);
        }
        return parent[i];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 启发式合并 rank低的合并入rank高的集合中
     *
     * @param x
     * @param y
     * @return
     */
    public int union(int x, int y) {
        int rootx = find(y);
        int rooty = find(x);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx] += 1;
            }
        }
        return rootx;
    }
}
