package com.howard.leetcode.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("最小栈")
class MinStackTest {

    private MinStack stack;

    @BeforeEach
    void setUp() {
        stack = new MinStack();
    }

    @Test
    @DisplayName("将元素x推入栈中")
    void push() {
        stack.push(1);
    }

    @Test
    @DisplayName("删除栈顶的元素")
    void pop() {
        stack.push(1);
        stack.pop();
    }

    @Test
    @DisplayName("获取栈顶元素")
    void top() {
        stack.push(1);
        int result = stack.top();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("检索栈中的最小元素")
    void getMin() {
        stack.push(1);
        int result = stack.getMin();
        Assertions.assertThat(result).as(String.format("最小值为: %d", 1)).isEqualTo(1);
    }

    @Test
    @DisplayName("检索栈中的最小元素1")
    void getMin1() {
        stack.push(1);
        stack.push(2);
        stack.push(-2);
        int result = stack.getMin();
        Assertions.assertThat(result).as(String.format("最小值为: %d", -2)).isEqualTo(-2);
    }
}