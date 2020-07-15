package com.howard.leetcode.training;

public class Solution69 {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 0, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }


    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        int res = solution69.mySqrt(8);
        System.out.println(res);

        res = solution69.mySqrt(4);
        System.out.println(res);

        res = solution69.mySqrt(1);
        System.out.println(res);

        res = solution69.mySqrt(2);
        System.out.println(res);
    }
}
