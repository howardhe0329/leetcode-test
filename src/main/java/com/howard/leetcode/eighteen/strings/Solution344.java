package com.howard.leetcode.eighteen.strings;

/**
 * 反转字符串
 *
 * @author howard he
 * @create 2019-03-15 11:26
 */
public class Solution344 {

    /**
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left ++;
            right --;
        }
    }

    private void swap(char[] s, int l, int r) {
        char tmp = s[l];
        s[l] = s[r];
        s[r] = tmp;
    }
}
