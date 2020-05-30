package com.howard.leetcode.tries;

/**
 * @author howard he
 * @create 2019-04-11 14:03
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie
     *
     * Time complexity: O(m) where m is the key length
     * Space complexity: O(m)
     * @param word
     */
    public void insert(String word) {
        TrieNode node = this.root;
        for (char ch: word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    /**
     * Search a prefix or whole key in trie and returns the node where search nodes
     *
     * Time complexity: O(m)
     * Space complexity: O(1)
     * @param word
     * @return
     */
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return null;
            }
            node = node.get(ch);
        }
        return node;
    }

    /**
     *
     * @param word
     * @return if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     *
     * @param word
     * @return if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String word) {
        return searchPrefix(word) != null;
    }
}
