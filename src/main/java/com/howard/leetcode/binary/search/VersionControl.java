package com.howard.leetcode.binary.search;

/**
 * 第一个错误的版本
 *
 * @author howard he
 * @create 2019-01-07 16:08
 */
public class VersionControl {

    private int firstErrorVersion;

    public VersionControl(int firstErrorVersion) {
        this.firstErrorVersion = firstErrorVersion;
    }

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int version) {
        return version >= firstErrorVersion;
    }
}
