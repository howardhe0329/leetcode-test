package com.howard.leetcode.eighteen.lists;

import java.util.List;

/**
 * This is the interface that allows for creating nested lists.
 * You should not implement it, or speculate about its implementation
 *
 * @author howard he
 * @create 2019-04-02 10:08
 */
public interface NestedInteger {

    /**
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    boolean isInteger();

    /**
     * Return null if this NestedInteger holds a nested list
     *
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     */
    Integer getInteger();

    /**
     * Return null if this NestedInteger holds a single integer
     *
     * @return the nested list that this NestedInteger holds, if it holds a nested list
     */
    List<NestedInteger> getList();
}
