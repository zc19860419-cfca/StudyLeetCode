package com.study.leetCode.trie;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class TrieNode {
    public char val;

    public boolean isWord;

    public TrieNode[] children = new TrieNode[75];

    public TrieNode(){}

    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }

}
