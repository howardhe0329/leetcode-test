package com.howard.leetcode.strings;

import java.util.HashSet;

/**
 * @author howard he
 * @create 2019-01-11 22:46
 */
public class StringTest {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add(new String("a"));
        set.add(new String("b"));
        set.add(new String("c"));
        System.out.println(set);

        for (String i: set) {
            i = "a";
        }
        System.out.println(set);

        String a1 = new String("aaa");
        String a2 = new String("aaa");
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));
    }
}
