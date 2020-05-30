package com.howard.leetcode.eighteen.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 打乱数组
 *
 * @author howard he
 * @create 2019-03-19 10:35
 */
public class Solution384 {

    private int[] array;
    private int[] original;
    private Random rand = new Random();


    public Solution384(int[] nums) {
        this.array = nums;
        this.original = nums.clone();
    }

    private List<Integer> getArrayCopyOf() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    public int[] shuffle() {
        List<Integer> aux = getArrayCopyOf();
        for (int i = 0; i < array.length; i++) {
            int removeIndex = rand.nextInt(aux.size());
            array[i] = aux.get(removeIndex);
            aux.remove(removeIndex);
        }
        return this.array;
    }


}
