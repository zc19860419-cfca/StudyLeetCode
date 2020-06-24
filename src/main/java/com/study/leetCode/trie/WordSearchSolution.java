package com.study.leetCode.trie;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same let
 * ter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * <p>
 * Related Topics 数组 回溯算法
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 */
class WordSearchSolution {

    private boolean found = false;

    /**
     * x 方向矩阵
     */
    private static final int[] dx = new int[]{-1, 0, 1, 0};
    /**
     * y 方向矩阵
     */
    private static final int[] dy = new int[]{0, -1, 0, 1};

    /**
     * <pre>
     * 利用DFS深度优先 以及方向矩阵在矩阵中进行扩散，再利用Trie树搜索是否存在单词。
     * 方向矩阵:
     *              (x,y-1)
     *                |
     * (x-1,y) ---- (x,y) ---- (x+1,y)
     *                |
     *              (x,y+1)
     * 左  上  右 下
     * dx=[-1, 0, 1, 0]
     * dy=[ 0,-1, 0, 1]
     * </pre>
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        found = false;
        boolean result;
        if (null == word || word.isEmpty()) {
            result = false;
        } else {
            Trie trie = new Trie();
            trie.insert(word);

            boolean[][] visited = new boolean[board.length][];
            int cols;
            for (int row = 0; row < board.length; row++) {
                cols = board[row].length;
                visited[row] = new boolean[cols];
                for (int col = 0; col < cols; col++) {
                    visited[row][col] = false;
                }
            }

            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    dfs(board, visited, "", row, col, trie);
                }
            }
            result = found;
        }

        return result;
    }

    /**
     * @param board     面板
     * @param visited   是否访问的标示
     * @param searching 当前查找的单词
     * @param row       行号
     * @param col       列号
     * @param trie      单词树
     * @return
     */
    private void dfs(char[][] board, boolean[][] visited, String searching, int row, int col, Trie trie) {
        if (!found) {
            //System.out.println(String.format("searching=%-10s,found = false", searching));
            //Lower and Upper bounds Check
            if ((row < board.length && row >= 0) && (col < board[0].length && col >= 0)) {
                if (!visited[row][col]) {
                    searching += board[row][col];
                    //System.out.println(String.format("searching=%-10s", searching));
                    if (trie.startsWith(searching)) {
                        //找到前缀
                        if (trie.search(searching)) {
                            //找到单词
                            found = true;
                            //System.out.println(String.format("searching=%-10s,found = true", searching));
                        } else {
                            //找到前缀，但是还没有找到单词，需要上下左右四向扩展搜索
                            //标记当前格子被访问，避免深度优先重复使用这个格子
                            visited[row][col] = true;
                            dfs(board, visited, searching, row + dy[0], col + dx[0], trie);
                            dfs(board, visited, searching, row + dy[1], col + dx[1], trie);
                            dfs(board, visited, searching, row + dy[2], col + dx[2], trie);
                            dfs(board, visited, searching, row + dy[3], col + dx[3], trie);
                            if (!found) {
                                //如果当前格子的四向查找失败，将使用其他格子作为起始点进行回溯，所以重置标记位。否则不重置
                                visited[row][col] = false;
                            }
                        }

                    }
                }
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
