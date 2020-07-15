package com.howard.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 三数之和
 *
 * @author howard he
 * @create 2019-03-04 14:15
 */
public class Solution15 {

    /**
     *
     * @param nums array of int
     * @return List<List<Integer>>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2)
            return new ArrayList<>(0);
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0)
                    while (i < j && nums[i] == nums[++i]);
                else if (sum > 0)
                    while (i < j && nums[j] == nums[--j]);
                else {
                    resultList.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return resultList;
    }

    /**
     * 双循环 + HashMap
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length <= 2) return new ArrayList<>(0);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>(nums.length - 1);
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                Integer exist = map.get(v);
                if (exist != null) {
                    List<Integer> list = Arrays.asList(nums[i], v, nums[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                } else {
                    map.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length <= 2) return Collections.emptyList();
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        list.sort(Comparator.naturalOrder());
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        List<List<Integer>> resultList = solution.threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(resultList);
    }

}
