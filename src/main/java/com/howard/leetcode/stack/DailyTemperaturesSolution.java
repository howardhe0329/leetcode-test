package com.howard.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 *
 * @author howard he
 * @create 2018-12-28 14:12
 */
public class DailyTemperaturesSolution {

    /**
     *
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    /**
     * 时间复杂度O(N * W)
     * N是T.length W是温度[30, 100]之间，就是71.
     * 所以W是个固定值，所以时间复杂度可以是O(N)
     *
     * 空间复杂度O(N + W)
     *
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; i--) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; t++) {
                if (next[t] < warmer_index) {
                    warmer_index = next[t];
                }
            }
            if (warmer_index < Integer.MAX_VALUE) {
                ans[i] = warmer_index - i;
            }
            next[T[i]] = i;
        }
        return ans;
    }

    /**
     *
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param T
     * @return
     */
    public int[] dailyTemperatures1(int[] T) {
        if (T == null || T.length == 0) {
            return new int[] {};
        }
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int curr = T[i];
            int counter = 0;
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > curr) {
                    counter = j - i;
                    break;
                }
            }
            result[i] = counter;
        }
        return result;
    }
}
