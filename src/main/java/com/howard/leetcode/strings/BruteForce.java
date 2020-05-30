package com.howard.leetcode.strings;

/**
 * BF算法
 * 暴力匹配算法
 *
 * @author howard he
 * @create 2019-01-04 17:54
 */
public class BruteForce {

    /**
     * 时间复杂度为O(M * N)
     * 空间复杂度为O(1)
     *
     * @param main 主串
     * @param sub   模串
     * @return pos
     */
    public int indexOf(String main, String sub) {
        if (main == null || main.isEmpty() ||
                sub == null || sub.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < main.length(); i++) {
            boolean is = true;
            for (int j = 0; j < sub.length(); j++) {
                if (i + j >= main.length()) {
                    is = false;
                    break;
                }
                if (main.charAt(i + j) != sub.charAt(j)) {
                    is = false;
                    break;
                }
            }
            if (is) {
                return i;
            }
        }
        return -1;
    }
}
