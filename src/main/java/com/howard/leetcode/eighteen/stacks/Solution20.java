package com.howard.leetcode.eighteen.stacks;

import java.util.*;

public class Solution20 {



    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {put('(', ')'); put('[',']'); put('{', '}'); put('?', '?');}
        };
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) stack.push(c);
            else if (!map.get(stack.pop()).equals(c)) return false;
        }
        return stack.size() == 1;
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        String s = "()";
        boolean res = solution20.isValid(s);
        System.out.println(s + " is valid: " + res);

        s = "()[]{}";
        res = solution20.isValid(s);
        System.out.println(s + " is valid: " + res);

        s = "(]";
        res = solution20.isValid(s);
        System.out.println(s + " is valid: " + res);

        s = "([)]";
        res = solution20.isValid(s);
        System.out.println(s + " is valid: " + res);

        s = "{[]}";
        res = solution20.isValid(s);
        System.out.println(s + " is valid: " + res);

    }
}
