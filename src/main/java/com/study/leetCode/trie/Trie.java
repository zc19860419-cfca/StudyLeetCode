package com.study.leetCode.trie;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * <p>
 * <p>
 * Note:
 * <p>
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * <p>
 * Related Topics 设计 字典树
 */

//leetcode submit region begin(Prohibit modification and deletion)
public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode ws = root;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (null == ws.children[c - '0']) {
                ws.children[c - '0'] = new TrieNode(c);
            }
            ws = ws.children[c - '0'];
        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        boolean found = true;
        TrieNode ws = root;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (null == ws.children[c - '0']) {
                found = false;
                break;
            }
            ws = ws.children[c - '0'];
        }

        found = (found) ? ws.isWord : found;
        return found;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        boolean isStartsWith = true;
        TrieNode ws = root;
        char c;
        for (int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            if (null == ws.children[c - '0']) {
                isStartsWith = false;
                break;
            }
            ws = ws.children[c - '0'];
        }
        return isStartsWith;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

