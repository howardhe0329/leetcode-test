package com.howard.leetcode.eighteen.lists;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author howard he
 * @create 2019-04-02 10:10
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        pushList(nestedList);
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;
            }
            stack.pop();
            pushList(curr.getList());
        }
        return false;
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    private void pushList(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) {
            return;
        }
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}
