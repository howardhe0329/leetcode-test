package com.howard.leetcode.training;

/**
 * @author howard
 */
public class Solution213 {

    public int rob(int[] nums) {
        int n;
        if ((n = nums.length) == 1) return nums[0];
        long start = System.currentTimeMillis();
//        int res = Math.max(recursiveMemo(nums, 0, n - 2, new int[n]), recursiveMemo(nums, 1, n - 1, new int[n]));
        int res = Math.max(bottomUp(nums, 0, n - 1), bottomUp(nums, 1, n));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) / 1000);
        return res;
    }

    private int recursive(int[] nums, int index, int n) {
        if (n < index) return 0;
        return Math.max(recursive(nums, index, n - 2) + nums[n], recursive(nums, index, n - 1));
    }

    private int recursiveMemo(int[] nums, int index, int n, int[] memo) {
        if (n < index) return 0;
        if (memo[n] != 0) return memo[n];
        return memo[n] = Math.max(recursive(nums, index, n - 2) + nums[n], recursive(nums, index, n - 1));
    }

    private int bottomUp(int[] nums, int lo, int hi) {
        int one = 0, two = 0;
        for (int i = lo; i < hi; i++) {
            int temp = Math.max(two, one + nums[i]);
            one = two;
            two = temp;
        }
        return two;
    }

    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
        int res = solution213.rob(new int[]{2, 3, 2});
        System.out.println(res);

        res = solution213.rob(new int[] {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240});
        System.out.println(res);

    }
}
