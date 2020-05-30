package com.howard.leetcode.eighteen.hashs;

import java.util.*;

/**
 * @author howard he
 * @create 2019-04-03 10:24
 */
public class RandomizedSet {

    private List<Integer> nums;
    private Map<Integer, Integer> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        if (index < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            map.put(last, index);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
