package com.howard.leetcode.binary.search;

/**
 * 猜数字游戏
 *
 * @author howard he
 * @create 2019-01-07 14:06
 */
public class GuessGame {

    private int num;

    public GuessGame(int num) {
        this.num = num;
    }

    /**
     * 猜数字API
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int guess(int num) {
        if (num == this.num) {
            return 0;
        } else if (num < this.num) {
            return -1;
        } else {
            return 1;
        }
    }
}
