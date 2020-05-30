package com.howard.leetcode.eighteen.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author howard he
 * @create 2019-03-15 10:26
 */
public class Solution387 {

    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] letters = new int[26];
        int aIndex = Character.hashCode('a');
        for (int i = 0; i < s.length(); i++) {
            letters[s.codePointAt(i) - aIndex] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.codePointAt(i) - aIndex] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Integer, Integer> dicMap = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            dicMap.put(s.codePointAt(i), dicMap.getOrDefault(s.codePointAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (dicMap.get(s.codePointAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
