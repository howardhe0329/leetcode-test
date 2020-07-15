package com.howard.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有效的字母异位词
 *
 * @author howard he
 * @create 2019-01-11 10:12
 */
public class IsAnagramSolution {

    /**
     * 是否是异位词
     * <p>
     * 时间复杂度为O(Max(M, N))
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()
                || s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.codePointAt(i) - 97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int idx = t.codePointAt(i) - 97;
            if (a[idx] > 0) {
                a[idx]--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()
                || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int val = map.getOrDefault(c, 0);
            if (val < 1) {
                return false;
            }
            map.put(c, val - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("中国".charAt(0));
        System.out.println("a".codePointAt(0));

        IsAnagramSolution solution = new IsAnagramSolution();
        String s = "anagram";
        String t = "nagaram";
        boolean res = solution.isAnagram(s, t);
        System.out.println(res);

        s = "rat";
        t = "car";
        res = solution.isAnagram(s, t);
        System.out.println(res);

        s = "中花人民";
        t = "民中花人在";
        res = solution.isAnagram(s, t);
        System.out.println(res);


    }
}
