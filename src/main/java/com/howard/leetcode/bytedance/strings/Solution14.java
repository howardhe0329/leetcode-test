package com.howard.leetcode.bytedance.strings;

/**
 * Longest common prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * if there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 *
 * @author howard he
 * @create 2019-04-11 09:27
 */
public class Solution14 {

    /**
     * Binary Search
     *
     * Time complexity: O(Slogn)
     *
     * Space complexity: O(1)
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String s: strs) {
            minLen = Math.min(minLen, s.length());
        }
        int lo = 0;
        int hi = minLen;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (isCommonPrefix(strs, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return strs[0].substring(0, hi);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String tmp = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(tmp)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Divide & Conquer
     * Time complexity: O(S)
     * Space complexity: O(mlogn)
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) return strs[l];
        int mid = (l + r) / 2;
        String left = longestCommonPrefix(strs, l, mid);
        String right = longestCommonPrefix(strs, mid + 1, r);
        return commonPrefix(left, right);
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    /**
     * vertical scanning
     * <p>
     * Time complexity: O()
     * <p>
     * Space complexity: O()
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * horizontal scanning
     * <p>
     * Time complexity: O(S)
     * where S is the sum of all characters in all strings.
     * Space complexity: O(1)
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

}
