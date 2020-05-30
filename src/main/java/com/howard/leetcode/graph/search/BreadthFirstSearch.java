package com.howard.leetcode.graph.search;

import com.howard.leetcode.graph.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索
 *
 * @author howard he
 * @create 2019-01-04 16:31
 */
public class BreadthFirstSearch {

    /**
     * 利用广度优先搜索计算最短路径
     *
     * @param graph 数据
     * @param s     顶点（起始）
     * @param t     顶点（结束）
     */
    public void bfs(Graph graph, int s, int t) {
        LinkedList<Integer>[] data = graph.getData();
        boolean[] visited = new boolean[data.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int[] prev = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            List<Integer> list = data[v];
            for (Integer item : list) {
                if (item == t) {

                    return;
                }
                if (visited[item]) {
                    continue;
                }
                visited[item] = true;
                prev[item] = v;
                queue.offer(item);
            }
        }
    }
}
