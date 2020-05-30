package com.howard.leetcode.tries;

/**
 * Trie
 *
 * @author howard he
 * @create 2019-04-11 13:55
 */
public class TrieNode {

    /**
     * R links to node children
     */
    private TrieNode[] links;
    private final int R = 26;
    private boolean end;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        end = true;
    }

    public boolean isEnd() {
        return end;
    }

}
