package com.howard.leetcode.strings;

import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    private void helper(char[] s, int lo, int hi) {
        if (lo >= hi) return;
        helper(s, lo + 1, hi - 1);
        char swap = s[lo];
        s[lo] = s[hi];
        s[hi] = swap;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] s = "hello".toCharArray();
        reverseString.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
