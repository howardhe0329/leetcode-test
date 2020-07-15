package com.howard.leetcode.strings;

import java.util.*;

public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            String sortedStr = String.valueOf(sorted);
            List<String> items = map.getOrDefault(sortedStr, new ArrayList<>());
            items.add(strs[i]);
            map.put(sortedStr, items);
        }
        for (List<String> items: map.values())
            result.add(items);
        return result;
    }



    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution49.groupAnagrams(strs);
        System.out.println(res);

        strs = new String[] {"", "b", ""};
        res = solution49.groupAnagrams(strs);
        System.out.println(res);
    }
}
