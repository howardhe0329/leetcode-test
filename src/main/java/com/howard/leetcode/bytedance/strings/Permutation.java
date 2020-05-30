package com.howard.leetcode.bytedance.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列
 *
 * @author howard he
 * @create 2019-04-12 09:07
 */
public class Permutation {

    public List<String> permute(String str) {
        List<String> resultList = new ArrayList<>();
        permute(str, 0, resultList);
        return resultList;
    }


    public void permute(String str, int l,  List<String> resultList) {
        if (l == str.length()) {
            return;
        }
        System.out.println(String.format("str: %s, l: %d \n", str, l));
        for (int i = l; i < str.length(); i++) {
            permute(str, l + 1, resultList);
        }
    }
}
