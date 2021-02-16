package com.study.leetCode.disjointSet;

/**
 * @Author: zhangchong
 * @Description: 547. Number of Provinces(省份数量)
 * //There are n cities. Some of them are connected, while some are not. If city a
 * //is connected directly with city b, and city b is connected directly with city c,
 * // then city a is connected indirectly with city c.
 * //
 * // A province is a group of directly or indirectly connected cities and no other
 * // cities outside of the group.
 * //
 * // You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * //ith city and the jth city are directly connected, and isConnected[i][j] = 0 othe
 * //rwise.
 * //
 * // Return the total number of provinces.
 * //
 * //
 * // Example 1:
 * //
 * //
 * //Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * //Output: 2
 * //
 * //
 * // Example 2:
 * //
 * //
 * //Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * //Output: 3
 * //
 * //
 * //
 * // Constraints:
 * //
 * //
 * // 1 <= n <= 200
 * // n == isConnected.length
 * // n == isConnected[i].length
 * // isConnected[i][j] is 1 or 0.
 * // isConnected[i][i] == 1
 * // isConnected[i][j] == isConnected[j][i]
 * //
 * // Related Topics 深度优先搜索 并查集
 */
public class NumOfProvicesSolution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int nr = isConnected.length;
        int nc = isConnected[0].length;
        UnionFind uf = new UnionFind(isConnected);
        //合并
        for (int row = 0; row < nr; ++row) {
            for (int col = 0; col < nc; ++col) {
                if (isConnected[row][col] == '1') {
                    isConnected[row][col] = '0';
                    //合并上（上面一行不能越界）
                    if (row - 1 >= 0 && isConnected[row - 1][col] == '1') {
                        uf.union(row * nc + col, (row - 1) * nc + col);
                    }
                    //合并下（下面一行不能越界）
                    if (row + 1 < nr && isConnected[row + 1][col] == '1') {
                        uf.union(row * nc + col, (row + 1) * nc + col);
                    }
                    //合并左（左边一列不能越界）
                    if (col - 1 >= 0 && isConnected[row][col - 1] == '1') {
                        uf.union(row * nc + col, row * nc + col - 1);
                    }
                    //合并右（右边一列不能越界）
                    if (col + 1 < nc && isConnected[row][col + 1] == '1') {
                        uf.union(row * nc + col, row * nc + col + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }

    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(int[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            int id;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    id = i * n + j;
                    if (grid[i][j] == 1) {
                        parent[id] = id;
                        ++count;
                    }
                    rank[id] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
