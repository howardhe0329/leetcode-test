package com.howard.leetcode.math;

/**
 * 两个数互换
 *
 * @author howard he
 * @create 2019-03-13 09:49
 */
public class XORSolution {

    public void swap(int[] nums, int x, int y) {
        nums[x] = nums[x] ^ nums[y];
        nums[y] = nums[x] ^ nums[y];
        nums[x] = nums[x] ^ nums[y];
    }
}
