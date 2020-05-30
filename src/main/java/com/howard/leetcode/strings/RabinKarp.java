package com.howard.leetcode.strings;

/**
 * RK算法
 *
 * @author howard he
 * @create 2019-01-04 18:14
 */
public class RabinKarp {

    /**
     * 算法思路：
     * 主串的长度为n
     * 模式串的长度n
     * 那么主串中有n - m + 1个子串，分别对这些子串算出哈希值；然后逐个对模式串的哈希值进行比较。
     *
     * @param main
     * @param sub
     * @return
     */
    public int indexOf(String main, String sub) {
        if (main == null || main.isEmpty() ||
                sub == null || sub.isEmpty() ||
                main.length() < sub.length()) {
            return -1;
        }
        int subHash = 0;
        int mainHash = 0;
        for (int i = 0; i < sub.length(); i++) {
            subHash += sub.charAt(i);
            mainHash += main.charAt(i);
        }
        for (int i = 0; i < main.length() - sub.length() + 1; i++) {
            if (i != 0) {
                mainHash = mainHash - main.charAt(i - 1) + main.charAt(i + sub.length() - 1);
            }
            if (mainHash == subHash) {
                boolean is = true;
                for (int j = 0; j < sub.length(); j++) {
                    if (i + j >= main.length() || main.charAt(i + j) != sub.charAt(j)) {
                        is = false;
                    }
                }
                if (is) {
                    return i;
                }
            }
        }
        return -1;
    }

}
