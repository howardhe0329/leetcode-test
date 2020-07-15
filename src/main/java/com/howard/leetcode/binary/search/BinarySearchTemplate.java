package com.howard.leetcode.binary.search;

/**
 * 二分查找代码模板
 *
 * @author howard he
 * @create 2019-01-07 21:48
 */
public class BinarySearchTemplate {

    /**
     * 模板一
     * 最基本的二分查找
     * <p>
     * 用于查找可以通过访问数组中的单个索引来确定的元素或条件。
     *
     * @param nums
     * @param target
     * @return
     */
    public int template1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * 模板二
     *
     * 用于查找需要访问数组中当前索引及其直接右邻居索引的元素或条件。
     * @param nums
     * @param target
     * @return
     */
    public int template2(int[] nums, int target) {
        if (nums == null || nums.length == 0){ return -1;}
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if (nums[left] == target) return left;
        return -1;
    }

    /**
     * 模板三
     *
     * 用于搜索需要访问当前索引及其在数组中的直接左右邻居索引的元素或条件。
     *
     * @param nums
     * @param target
     * @return
     */
    public int template3(int[] nums, int target) {
        if (nums == null || nums.length == 0){ return -1;}
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid;
            else right = mid;
        }
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchTemplate template = new BinarySearchTemplate();
        int[] nums = new int[]{1, 3, 8, 13, 17, 20, 33, 45};
        int res = template.template1(nums, 48);
        System.out.println("template1: " + res);
        res = template.template2(nums, 48);
        System.out.println("template2: " + res);
        res = template.template3(nums, 48);
        System.out.println("template3: " + res);

    }
}
