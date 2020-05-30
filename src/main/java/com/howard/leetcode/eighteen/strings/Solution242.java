package com.howard.leetcode.eighteen.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author howard he
 * @create 2019-03-15 09:40
 */
public class Solution242 {

    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[26];
        int aIndex = Character.hashCode('a');
        for (int i = 0; i < s.length(); i++) {
            letters[s.codePointAt(i) - aIndex] += 1;
            letters[t.codePointAt(i) - aIndex] -= 1;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Integer, Integer> dicMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            dicMap.put(s.codePointAt(i), dicMap.getOrDefault(s.codePointAt(i), 0) + 1);
            dicMap.put(t.codePointAt(i), dicMap.getOrDefault(t.codePointAt(i), 0) - 1);
        }
        return dicMap.entrySet().stream().noneMatch((e) -> e.getValue() != 0);
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Integer, Integer> dicMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            dicMap.put(s.codePointAt(i), dicMap.getOrDefault(s.codePointAt(i), 0) + 1);
//            dicMap.put(t.codePointAt(i), dicMap.getOrDefault(t.codePointAt(i), 0) - 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Integer v = dicMap.put(t.codePointAt(i), dicMap.getOrDefault(t.codePointAt(i), 0) - 1);
            if (v == null || v < 1) {
                return false;
            }
        }
        return true;
    }
}
