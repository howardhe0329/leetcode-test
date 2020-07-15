package com.howard.leetcode;

public class Solution263 {

    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0)
                num /= i;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        Solution263 solution263 = new Solution263();
        int num = 6;
        boolean res = solution263.isUgly(num);
        System.out.println("num: " + num + " is: " + res);

        num = 8;
        res = solution263.isUgly(num);
        System.out.println("num: " + num + " is: " + res);

        num = 14;
        res = solution263.isUgly(num);
        System.out.println("num: " + num + " is: " + res);
    }
}
