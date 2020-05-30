package com.howard.leetcode.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("用栈实现队列")
class MyQueueTest {

    private MyQueue queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue();
    }

    @Test
    @DisplayName("测试")
    void test() {
        queue.push(1);
        queue.push(2);
        int result = queue.peek();  // 返回 1
        Assertions.assertThat(result).isEqualTo(1);
        result = queue.pop();   // 返回 1
        Assertions.assertThat(result).isEqualTo(1);
        boolean empty = queue.empty(); // 返回 false
        Assertions.assertThat(empty).isFalse();
    }

    @Test
    void push() {
    }

    @Test
    void pop() {
    }

    @Test
    void peek() {
    }

    @Test
    void empty() {
    }
}