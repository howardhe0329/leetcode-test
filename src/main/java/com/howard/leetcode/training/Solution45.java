package com.howard.leetcode.training;

import java.util.LinkedList;
import java.util.Queue;

public class Solution45 {

    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public int jump1(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.remove();
                if (index == nums.length - 1) return depth;
                for (int j = 1; j <= nums[index]; j++) {
                    int neighborIndex = index + j;
                    if (neighborIndex > nums.length - 1) break;
                    if (visited[neighborIndex]) continue;
                    queue.offer(neighborIndex);
                    visited[neighborIndex] = true;
                }
            }
            depth++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        int res = solution45.jump1(new int[]{2, 3, 1, 1, 4});
        System.out.println(res);
    }
}