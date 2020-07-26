package com.howard.leetcode.training;

public class Solution287 {

    public int findDuplicate1(int[] nums) {
        int lo = 1;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) cnt++;
            }

            if (cnt > mid)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution287 solution287 = new Solution287();
        int res = solution287.findDuplicate(new int[]{1, 4, 4, 2, 4});
        System.out.println(res);

        res = solution287.findDuplicate(new int[]{3, 1, 3, 4, 2});
        System.out.println(res);

    }
}
