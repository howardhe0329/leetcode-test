package com.howard.leetcode.binary.search;

/**
 * 二分查找实现x平方根
 *
 * @author howard he
 * @create 2019-01-07 10:52
 */
public class MySqrtDoubleSolution {

    /**
     *
     * 利用二分查找法计算x的平方根
     *
     * @param x
     * @param threshold
     * @return
     */
    public double mySqrt(double x, double threshold) {
        double left = 0.0d;
        double right = x;
        while (left < right) {
            double mid = left + ((right - left) / 2);
            double guess = mid * mid;
            if (Math.abs(guess - x) < threshold) {
                return mid;
            } else if (guess > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}
