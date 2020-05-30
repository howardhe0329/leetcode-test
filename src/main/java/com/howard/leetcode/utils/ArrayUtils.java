package com.howard.leetcode.utils;

/**
 * 数组相关工具类
 *
 * @author howard he
 * @create 2019-03-27 17:11
 */
public class ArrayUtils {

    /**
     *
     * @param array
     * @param a
     * @param b
     * @param <T>
     */
    public static <T> void exch(T[] array, int a, int b) {
        T tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
