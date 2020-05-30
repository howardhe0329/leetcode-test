package com.howard.leetcode.graph;

import java.util.LinkedList;

/**
 * 图数据结构
 *
 * @author howard he
 * @create 2019-01-04 16:27
 */
public class Graph {

    /**
     * 顶点个数
     */
    private int v;
    /**
     * 邻接表
     */
    private LinkedList<Integer>[] data;

    public Graph(int v) {
        this.v = v;
        data = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            data[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) {
        data[s].add(t);
        data[t].add(s);
    }

    public LinkedList<Integer>[] getData() {
        return data;
    }
}
