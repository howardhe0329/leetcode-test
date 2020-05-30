package com.howard.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 *
 * @author howard he
 * @create 2019-02-20 14:13
 */
public class Solution202 {

    /**
     * 是否为快乐数
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            int temp = 0;
            while (n > 0) {
                temp = temp + (n % 10) * (n % 10);
                n = n / 10;
            }
            n = temp;
            if (set.contains(n)) {
                return false;
            }
        }
        return true;
    }
}
