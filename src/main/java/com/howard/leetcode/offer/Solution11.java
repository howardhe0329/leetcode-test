package com.howard.leetcode.offer;

public class Solution11 {

    public int minArray(int[] numbers) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] > numbers[hi]) lo = mid + 1;
            else if (numbers[mid] < numbers[hi]) hi = mid;
            else hi--;
        }
        return numbers[lo];
    }

    public int minArray1(int[] numbers) {
        return helper(numbers, 0, numbers.length - 1);
    }

    private int helper(int[] numbers, int lo, int hi) {
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] > numbers[hi])
                return helper(numbers, mid, hi);
            else if (numbers[mid] < numbers[hi])
                return helper(numbers, lo, mid);
            else
                return Math.min(helper(numbers, lo, mid), helper(numbers, mid, hi));
        }
        return Math.min(numbers[lo], numbers[hi]);
    }


    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int res = solution11.minArray(new int[]{1, 3, 5});
        System.out.println(res);

        res = solution11.minArray(new int[]{3, 1});
        System.out.println(res);

        res = solution11.minArray(new int[]{3,4,5,1,2});
        System.out.println(res);

        res = solution11.minArray(new int[]{2, 2, 2, 0, 1});
        System.out.println(res);

        res = solution11.minArray(new int[]{1});
        System.out.println(res);

        res = solution11.minArray(new int[]{2, 2, 2, 0, 2});
        System.out.println(res);


    }
}
