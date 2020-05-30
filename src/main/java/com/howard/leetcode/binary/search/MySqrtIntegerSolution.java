package com.howard.leetcode.binary.search;

/**
 * x的平方根,返回整数
 *
 * @author howard he
 * @create 2019-01-07 10:29
 */
public class MySqrtIntegerSolution {

    /**
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 0) {
            return x;
        }
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long guess = (long) mid * mid;
            if (guess == x) {
                return mid;
            } else if (guess > x) {
                right = mid - 1;
            } else {
                left =  mid + 1;
            }
        }
        return right;
    }
}
