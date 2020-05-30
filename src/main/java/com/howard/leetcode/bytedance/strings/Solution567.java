package com.howard.leetcode.bytedance.strings;

import java.util.Arrays;

/**
 * Permutation in String
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 * @author howard he
 * @create 2019-04-11 14:57
 */
public class Solution567 {

    /**
     * sliding window [optimized]
     *
     * Time complexity: O(l1 + (l2 - l1)
     * Space complexity: O(1)
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1array = new int[26];
        int[] s2array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1array[s1.charAt(i) - 'a']++;
            s2array[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1array[i] == s2array[i])
                count++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a';
            int l = s2.charAt(i) - 'a';
            if (count == 26) return true;
            s2array[r]++;
            if (s1array[r] == s2array[r])
                count++;
            else if (s2array[r] == s1array[r] + 1)
                count--;
            s2array[l]--;
            if (s2array[l] == s1array[l])
                count++;
            else if (s2array[l] == s1array[l] - 1)
                count--;
        }
        return count == 26;
    }

    /**
     * sliding window
     *
     * Time complexity: O(l1 + 26 * (l2 - l1)
     * Space complexity: O(1)
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1array = new int[26];
        int[] s2array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1array[s1.charAt(i) - 'a']++;
            s2array[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1array, s2array)) {
                return true;
            }
            s2array[s2.charAt(i) - 'a']--;
            s2array[s2.charAt(i + s1.length()) - 'a']++;
        }
        return matches(s1array, s2array);
    }

    /**
     * using array
     *
     * Time complexity: O(l1 + 26 * l1 * (l2 - l1)
     * Space complexity: O(1)
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        int[] s1array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1array[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2array = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2array[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1array, s2array)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] s1array, int[] s2array) {
        for (int i = 0; i < 26; i++) {
            if (s1array[i] != s2array[i]) {
                return false;
            }
        }
        return true;
    }
}
