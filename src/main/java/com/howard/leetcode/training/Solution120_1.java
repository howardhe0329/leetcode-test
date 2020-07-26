package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author howard
 */
public class Solution120_1 {

    public int minimumTotal(List<List<Integer>> triangle) {
        // TODO
        return 0;
    }


    public static void main(String[] args) {
        Solution120_1 solution120_1 = new Solution120_1();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int res = solution120_1.minimumTotal(triangle);
        System.out.println(res);
    }
}
