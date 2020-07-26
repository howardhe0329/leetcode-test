package com.howard.leetcode.training;

import java.util.HashSet;
import java.util.Set;

public class Solution874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, direction = 0, result = 0;
        Set<String> dict = new HashSet<>();
        for (int[] o : obstacles) {
            dict.add(o[0] + " " + o[1]);
        }
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction + 3) % 4;
            } else {
                while (command-- > 0 && !dict.contains((x + directions[direction][0]) + " " + (y + directions[direction][1]))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution874 solution874 = new Solution874();
        int res = solution874.robotSim(new int[]{-2,8,3,7,-1}
            , new int[][]{{-4,-1}, {1, -1}, {1, 4}, {5, 0}, {4, 5}, {-2,-1}, {2, -5}, {5, 1}, {-3, -1}, {5, -3}});
        System.out.println(res);
    }
}