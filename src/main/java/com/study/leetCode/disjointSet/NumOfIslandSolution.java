package com.study.leetCode.disjointSet;

/**
 * @Author: zhangchong
 * @Description: 200. Number of Islands 岛屿数量
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number
 * of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands h
 * orizontally or vertically. You may assume all four edges of the grid are all sur
 * rounded by water.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 并查集
 */
public class NumOfIslandSolution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        //合并
        for (int row = 0; row < nr; ++row) {
            for (int col = 0; col < nc; ++col) {
                if (grid[row][col] == '1') {
                    grid[row][col] = '0';
                    //合并上（上面一行不能越界）
                    if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                        uf.union(row * nc + col, (row - 1) * nc + col);
                    }
                    //合并下（下面一行不能越界）
                    if (row + 1 < nr && grid[row + 1][col] == '1') {
                        uf.union(row * nc + col, (row + 1) * nc + col);
                    }
                    //合并左（左边一列不能越界）
                    if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                        uf.union(row * nc + col, row * nc + col - 1);
                    }
                    //合并右（右边一列不能越界）
                    if (col + 1 < nc && grid[row][col + 1] == '1') {
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

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            int id;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    id = i * n + j;
                    if (grid[i][j] == '1') {
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
