package com.howard.leetcode;

/**
 * 并查集
 *
 * @author howard he
 * @create 2019-04-16 10:09
 */
public class QuickUnionUF {

    private int[] roots;

    public QuickUnionUF(int N) {
        roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
    }

    /**
     * 查找root
     * @param i
     * @return
     */
    private int findRoot(int i) {
        int root = i;
        while (root != roots[root])
            root = roots[root];
        // 路径压缩
        while (i != roots[i]) {
            int temp = roots[i];
            roots[i] = root;
            i = temp;
        }
        return root;
    }

    /**
     * 判断两个节点是否是同一个root
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    /**
     * 合并两个节点
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int proot = findRoot(p);
        int qroot = findRoot(q);
        roots[proot] = qroot;
    }
}
