package com.howard.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @author howard he
 * @create 2018-12-28 12:35
 */
public class IsValidBracketsSolution {

    /**
     * 有效字符串
     * 用栈数据结构
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (bracketMap.containsValue(c)) {
                stack.push(c);
                continue;
            }
            if (bracketMap.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (bracketMap.get(c).charValue() != stack.pop().charValue()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
