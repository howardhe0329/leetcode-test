package com.howard.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {

    private final int[] data;
    private final Map<Integer, Integer> map = new HashMap<>();
    private int size;

    public LRUCache1(int capacity) {
        data = new int[capacity];
        this.size = 0;
    }

    public int get(int key) {
        Integer idx = map.get(key);
        if (idx == null) {
            return -1;
        }
        return data[idx];
    }

    public void put(int key, int value) {
        boolean exist = map.containsKey(key);
        if (exist) {
            data[map.get(key)] = value;
        } else if (size < data.length) {
            data[size++] = value;
        } else {

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr.length);
        arr[0] = 1;
        System.out.println(arr.length);
    }
}
