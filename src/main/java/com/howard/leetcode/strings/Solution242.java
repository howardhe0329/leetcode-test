package com.howard.leetcode.strings;

/**
 * 两个字符串是否为异位词
 *
 * @author howard he
 * @create 2019-02-21 15:21
 */
public class Solution242 {

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.codePointAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            if ((dict[t.codePointAt(i) - 'a'] -= 1) < 0) {
                return false;
            }
        }
        return true;
    }
}
