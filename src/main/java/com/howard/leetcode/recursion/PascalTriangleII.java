package com.howard.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangleII {

    public List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        if (rowIndex >= 0)
            list.add(1);
        for (int i = 1, num = 1; i <= rowIndex; i++) {
            num = (int) ((double) num / i * (rowIndex - i + 1) + 0.1);
            list.add(num);
        }
        return list;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(recursive(rowIndex, i, map));
        }
//        System.out.println("map: " + map.size());
        return result;
    }

    private int recursive(int row, int col, Map<Integer, Integer> map) {
        if (row == 0 || col == 0 || row == col) return 1;
        if (col == 1) return row;
        if (map.containsKey(key(row, col)))
            return map.get(key(row, col));
        else {
            int res = recursive(row - 1, col - 1, map) + recursive(row - 1, col, map);
            map.put(key(row, col), res);
            return res;
        }
    }

    private Integer key(int row, int col) {
        return (row << 5) + col;
    }

    public static void main(String[] args) {
        PascalTriangleII pascalTriangleII = new PascalTriangleII();

        int row = 0;
        List<Integer> res = pascalTriangleII.getRow(row);
//        System.out.println(res);
//        row = 1;
//        res = pascalTriangleII.getRow(row);
//        System.out.println(res);
//
//        row = 2;
//        res = pascalTriangleII.getRow(row);
//        System.out.println(res);
//
//        row = 3;
//        res = pascalTriangleII.getRow(row);
//        System.out.println(res);
//
//        row = 4;
//        res = pascalTriangleII.getRow(row);
//        System.out.println(res);
//
//        row = 5;
//        res = pascalTriangleII.getRow(row);
//        System.out.println(res);
//
//        row = 6;
//        res = pascalTriangleII.getRow(row);
//        System.out.println(res);
//
//        row = 7;
//        res = pascalTriangleII.getRow(row);
//        System.out.println(res);

        row = 5;
        res = pascalTriangleII.getRow1(row);
        System.out.println(res);
    }
}
