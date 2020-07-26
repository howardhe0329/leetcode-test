package com.howard.leetcode.training;

public class SolutionJump {

    public int jump(int[] nums) {
        int max = 0, end = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                count++;
                end = max;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SolutionJump solutionJump = new SolutionJump();
        int res = solutionJump.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(res);


    }
}
