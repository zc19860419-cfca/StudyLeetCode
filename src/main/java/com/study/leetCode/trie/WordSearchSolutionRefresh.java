package com.study.leetCode.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description 212. Word Search
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

class WordSearchSolutionRefresh {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode();
        for (String s : words) {
            trie.insert(s, trie);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                help(board, i, j, trie);
            }
        }

        return res;
    }

    List<String> res = new ArrayList<>();

    private void help(char[][] board, int i, int j, TrieNode trie) {
        char record = board[i][j];
        if (record == '#' || trie.children[record - 'a'] == null) {
            return;
        }


        trie = trie.children[record - 'a'];
        if (trie.word != null) {
            res.add(trie.word);
            trie.word = null;
        }

        board[i][j] = '#';
        if (i > 0) {
            help(board, i - 1, j, trie);
        }
        if (i < board.length - 1) {
            help(board, i + 1, j, trie);
        }
        if (j > 0) {
            help(board, i, j - 1, trie);
        }
        if (j < board[0].length - 1) {
            help(board, i, j + 1, trie);
        }

        board[i][j] = record;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;

        public void insert(String word, TrieNode root) {
            TrieNode nt = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (nt.children[index] == null) {
                    nt.children[index] = new TrieNode();
                }
                nt = nt.children[index];
            }
            nt.word = word;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

