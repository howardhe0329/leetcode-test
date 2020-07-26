package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author howard
 */
public class FindKClosestElementsSolution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length == 0 || k == 0) return Collections.emptyList();
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        return Arrays.stream(arr, lo, lo + k).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        FindKClosestElementsSolution solution = new FindKClosestElementsSolution();
        List<Integer> res = solution.findClosestElements(new int[]{1}, 1, 1);
        System.out.println(res);

        res = solution.findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5);
        System.out.println(res);

    }
}
