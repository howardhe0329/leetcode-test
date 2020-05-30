package com.howard.leetcode.math;

/**
 * 汉诺塔
 *
 * H(0) = 0
 * H(n) = H(n-1) + 1 + H(n-1)
 *
 * @author howard he
 * @create 2019-03-20 15:08
 */
public class TowerOfHanoi {

    public void hanoiOfTower(int n, String x, String y, String z) {
        if (n == 0) {
            return;
        }
        hanoiOfTower(n - 1, x, z, y);
        System.out.format("第%d个盘子，%s -> %s \n", n, x, y);
        hanoiOfTower(n - 1, z, y, x);
    }

    public static void main(String[] args) {
        TowerOfHanoi hanoi = new TowerOfHanoi();
        hanoi.hanoiOfTower(2, "A", "B", "C");
    }
}