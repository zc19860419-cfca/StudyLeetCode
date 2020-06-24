package com.study.leetCode.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description 79. Word Search
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * <p>
 * Input:
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 * <p>
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * <p>
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 * <p>
 * Related Topics 字典树 回溯算法
 * leetcode submit region begin(Prohibit modification and deletion)
 */

class WordSearchSolution2 {
    private Set<String> result = new HashSet<String>();

    /**
     * x 方向矩阵
     */
    private static final int[] dx = new int[]{-1, 0, 1, 0};
    /**
     * y 方向矩阵
     */
    private static final int[] dy = new int[]{0, -1, 0, 1};

    private boolean debug = false;


    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        boolean visited[][] = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        //1.terminator
        final boolean isTerminate = (x < 0 || x >= board.length || y < 0 || y >= board[0].length);
        if (!isTerminate) {
            final boolean isVisited = visited[x][y];
            if (!isVisited) {
                visit(board, visited, str, x, y, trie);

            } else {
                if (debug) {
                    System.err.println("isVisited[" + x + "][" + y + "]=true");
                }
            }
        } else {
            if (debug) {
                System.err.println("isTerminate=true");
            }
        }
    }

    private void visit(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        //2.process
        str += board[x][y];
        if (trie.startsWith(str)) {
            if (trie.search(str)) {
                result.add(str);
            }
            visited[x][y] = true;

            //3.drill down
            for (int i = 0; i < 4; i++) {
                dfs(board, visited, str, x + dx[i], y + dy[i], trie);
            }

            //4.clear status
            visited[x][y] = false;

        } else {
            if (debug) {
                System.err.println(str + " not preix");
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

