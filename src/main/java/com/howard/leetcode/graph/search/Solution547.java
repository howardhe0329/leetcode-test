package com.howard.leetcode.graph.search;

/**
 * Friend Circles
 *
 * @author howard he
 * @create 2019-04-16 10:49
 */
public class Solution547 {

    /**
     * using Union Find
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n == 0) return 0;
        UnionFind uf = new UnionFind(n, M);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) continue;
                int p = i * n + j;
                if (i > 0 && M[i - 1][j] == 1)
                    uf.union(p, p - n);
                if (i < n - 1 && M[i + 1][j] == 1)
                    uf.union(p, p + n);
                if (j > 0 && M[i][j - 1] == 1)
                    uf.union(p, p - 1);
                if (j < n - 1 && M[i][j + 1] == 1)
                    uf.union(p, p + 1);
            }
        }
        return uf.count;
    }

    private class UnionFind {
        private int[] roots;
        private int count;

        public UnionFind(int n, int[][] M) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (M[i][j] == 1) count++;
                }
            }
            roots = new int[n * n];
            for (int i = 0; i < n * n; i++) {
                roots[i] = i;
            }
        }

        public int find(int i) {
            int root = i;
            while (root != roots[root])
                root = roots[root];
            while (i != roots[i]) {
                int temp = roots[i];
                roots[i] = root;
                i = temp;
            }
            return root;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int proot = find(p);
            int qroot = find(q);
            if (proot == qroot) return;
            roots[qroot] = proot;
            count--;
        }
    }

    /**
     * using DFS
     *
     * @param M
     * @return
     */
    public int findCircleNum1(int[][] M) {
        int count = 0;
        int n = M.length;
        if (n == 0) return count;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    dfsMarking(M, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsMarking(int[][] M, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n || M[i][j] == 0) return;
        M[i][j] = 0;
        dfsMarking(M, n, i + 1, j);
        dfsMarking(M, n, i - 1, j);
        dfsMarking(M, n, i, j + 1);
        dfsMarking(M, n, i, j - 1);
    }
}
