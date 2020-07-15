package com.howard.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> newList;
        int i = 0;
        while (i < numRows) {
            newList = new ArrayList<>();
            newList.add(1);
            for (int j = 1; j < i; j++) {
                newList.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i != 0)
                newList.add(1);
            result.add(newList);
            i++;
        }
        return result;
    }

    public List<List<Integer>> generate(int numRows) {
        return helper(numRows);
    }

    private List<List<Integer>> helper(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = helper(--n);
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        for (int i = 1; i < n; i++) {
            newList.add(result.get(n - 1).get(i - 1) + result.get(n - 1).get(i));
        }
        if (n != 0) newList.add(1);
        result.add(newList);
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle triangle = new PascalTriangle();
        int numsRows = 5;
        List<List<Integer>> res = triangle.generate(numsRows);
        System.out.println(res);

    }
}
