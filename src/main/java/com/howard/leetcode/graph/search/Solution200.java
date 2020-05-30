package com.howard.leetcode.graph.search;

/**
 * Number of Islands
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 *
 * @author howard he
 * @create 2019-04-15 11:26
 */
public class Solution200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        if (m == 0) return count;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m, n, grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                int p = i * n + j;
                if (i > 0 && grid[i - 1][j] == '1')
                    uf.union(p, p - n);
                if (i < m - 1 && grid[i + 1][j] == '1')
                    uf.union(p, p + n);
                if (j > 0 && grid[i][j - 1] == '1')
                    uf.union(p, p - 1);
                if (j < n - 1 && grid[i][j + 1] == '1')
                    uf.union(p, p + 1);
            }
        }
        return uf.count;
    }

    /**
     * DFS depth first search
     * <p>
     * Time complexity: O(m * n)
     *
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) return count;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfsMarking(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void dfsMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfsMarking(grid, i + 1, j);
        dfsMarking(grid, i - 1, j);
        dfsMarking(grid, i, j + 1);
        dfsMarking(grid, i, j - 1);
    }

    private class UnionFind {
        private int[] roots;
        private int count;

        public UnionFind(int m, int n, char[][] grid) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') count++;
                }
            }
            roots = new int[m * n];
            for (int i = 0; i < m * n; i++) {
                roots[i] = i;
            }
        }

        private int findRoot(int i) {
            int root = i;
            while (root != roots[root])
                root = roots[root];
            // 压缩路径
            while (i != roots[i]) {
                int tmp = roots[i];
                roots[i] = root;
                i = tmp;
            }
            return root;
        }

        public boolean connected(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        public void union(int p, int q) {
            int proot = findRoot(p);
            int qroot = findRoot(q);
            if (proot == qroot) return;
            roots[qroot] = proot;
            count--;
        }
    }

}
