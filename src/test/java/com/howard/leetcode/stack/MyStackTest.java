package com.howard.leetcode.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("用队列实现栈功能")
class MyStackTest {

    private MyStack stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack();
    }

    @Test
    public void test() {
        stack.push(1);
        stack.push(2);

        int result = stack.top();   // returns 2
        Assertions.assertThat(result).isEqualTo(2);
        result = stack.pop();   // returns 2
        Assertions.assertThat(result).isEqualTo(2);
        boolean empty = stack.empty(); // returns false
        Assertions.assertThat(empty).isFalse();

    }

    @Test
    public void test1() {
        stack.push(1);
        stack.push(2);

        int result = stack.pop();   // returns 2
        Assertions.assertThat(result).isEqualTo(2);
        result = stack.top();   // returns 2
        Assertions.assertThat(result).isEqualTo(1);

    }
}