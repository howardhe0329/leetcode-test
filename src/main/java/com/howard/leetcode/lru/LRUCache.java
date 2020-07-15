package com.howard.leetcode.lru;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author howard
 */
public class LRUCache {

    private int capacity;
    private final LinkedList<Integer> items = new LinkedList<>();
    private final Map<Integer, Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("capacity error");
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null)
            return -1;
        items.remove(Integer.valueOf(value));
        items.offerFirst(value);
        return items.getFirst();
    }

    public void put(int key, int value) {
        boolean exist = map.containsKey(key);
        map.put(key, value);
        if (exist) {
            items.remove(Integer.valueOf(value));
        } else if (items.size() >= capacity) {
            map.remove(items.removeLast());
        }
        items.offerFirst(value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        int v1 = cache.get(1);
        System.out.println("v1: " + v1);
        cache.put(1, 1);
        int v2 = cache.get(1);
        System.out.println("v2: " + v2);
        cache.put(2, 2);
        int v3 = cache.get(2);
        System.out.println("v3: " + v3);
        cache.put(3, 3);
        int v4 = cache.get(3);
        System.out.println("v4: " + v4);
        int v5 = cache.get(1);
        System.out.println("v5: " + v5);
        int v6 = cache.get(2);
        System.out.println("v6: " + v6);

        cache.put(2, 2);
        System.out.println("v7: " + cache.get(2));

    }
}
