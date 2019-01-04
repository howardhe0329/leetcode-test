package com.howard.leetcode.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("自已实现循环队列")
class MyCircularQueueTest {

    private MyCircularQueue queue;
    private int k = 5;

    @BeforeEach
    void setUp() {
        queue = new MyCircularQueue(k);
    }

    @Test
    @DisplayName("从队首获取元素。测试队列有一个值的情况。返回正确的值")
    void frontHasValue() {
        int value = 1;
        queue.enQueue(value);
        int result = queue.Front();
        Assertions.assertThat(result).as("是否等于Value").isEqualTo(value);
    }

    @Test
    @DisplayName("从队首获取元素。测试队列为空的情况。方法返回-1")
    void frontNoHasValue() {
        int result = queue.Front();
        Assertions.assertThat(result).as("队列为空的情况").isEqualTo(-1);
    }

    @Test
    @DisplayName("从队首获取元素。测试队列有两个值的情况。返回正确的值")
    void frontHasValue1() {
        int value = 1;
        queue.enQueue(value);
        queue.enQueue(2);
        int result = queue.Front();
        Assertions.assertThat(result).as("是否等于Value").isEqualTo(value);
    }

    @Test
    @DisplayName("获取队尾元素。测试队列有一个值的情况。返回正确的值")
    void rearHasValue() {
        int value = 1;
        queue.enQueue(value);
        int result = queue.Rear();
        Assertions.assertThat(result).as("是否等于value").isEqualTo(value);
    }

    @Test
    @DisplayName("获取队尾元素。测试队列有两个值的情况。返回正确的值")
    void rearHasValue1() {
        int value = 1;
        queue.enQueue(2);
        queue.enQueue(value);
        int result = queue.Rear();
        Assertions.assertThat(result).as("是否等于value").isEqualTo(value);
    }

    @Test
    @DisplayName("获取队尾元素。测试队列为空的情况。返回-1")
    void rearNoHasValue() {
        int result = queue.Rear();
        Assertions.assertThat(result).as("是否等于value").isEqualTo(-1);
    }


    @Test
    @DisplayName("向循环队列插入一个元素。测试往空队列里插入一个元素，返回真")
    void enQueueIsTrue() {
        boolean result = queue.enQueue(1);
        Assertions.assertThat(result).as("返回true").isTrue();
    }

    @Test
    @DisplayName("向循环队列插入一个元素。测试往空队列里插入k个元素，返回真")
    void enQueueIsTrue1() {
        for (int i = 0; i < k; i++) {
            boolean result = queue.enQueue(i);
            Assertions.assertThat(result).as("返回true").isTrue();
        }
    }

    @Test
    @DisplayName("向循环队列插入一个元素。测试往已满的队列里插入1个元素，返回false")
    void enQueueIsFalse() {
        for (int i = 0; i < k; i++) {
            boolean result = queue.enQueue(i);
            Assertions.assertThat(result).as("返回true").isTrue();
        }
        boolean result = queue.enQueue(k + 1);
        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("从循环队列中删除一个元素。测试空队列，删除元素返回false")
    void deQueueIsFalse() {
        boolean result = queue.deQueue();
        Assertions.assertThat(result).as("返回false").isFalse();
    }

    @Test
    @DisplayName("从循环队列中删除一个元素。测试队列有一个元素，删除元素返回true")
    void deQueueIsTrue() {
        queue.enQueue(1);
        boolean result = queue.deQueue();
        Assertions.assertThat(result).as("返回true").isTrue();
    }

    @Test
    @DisplayName("检查循环队列是否为空。测试空队列的情况")
    void isEmptyIsTrue() {
        boolean result = queue.isEmpty();
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("检查循环队列是否为空。测试入队一次出队一次的情况")
    void isEmptyIsTrue1() {
        queue.enQueue(1);
        queue.deQueue();
        boolean result = queue.isEmpty();
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("检查循环队列是否为空。测试入队k次出队k次的情况")
    void isEmptyIsTrue2() {
        for (int i = 0; i < k; i++) {
            queue.enQueue(i);
            queue.deQueue();
        }
        boolean result = queue.isEmpty();
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("检查循环队列是否为空。测试入队k次出队k次的情况")
    void isEmptyIsTrue3() {
        for (int i = 0; i < k; i++) {
            queue.enQueue(i);
        }
        for (int i = 0; i < k; i++) {
            queue.deQueue();
        }
        boolean result = queue.isEmpty();
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("检查循环队列是否为空。测试入队一次的情况")
    void isEmptyIsFalse() {
        queue.enQueue(1);
        boolean result = queue.isEmpty();
        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("检查循环队列是否为空。测试入队k次的情况")
    void isEmptyIsFalse1() {
        for (int i = 0; i < k; i++) {
            queue.enQueue(i);
        }
        boolean result = queue.isEmpty();
        Assertions.assertThat(result).as("返回false").isFalse();
    }

    @Test
    @DisplayName("检查循环队列是否已满，测试队列空的情况")
    void isFullIsFalse() {
        boolean result = queue.isFull();
        Assertions.assertThat(result).as("返回false").isFalse();
    }

    @Test
    @DisplayName("检查循环队列是否已满，测试队列有一个元素的情况")
    void isFullIsFalse1() {
        queue.enQueue(1);
        boolean result = queue.isFull();
        Assertions.assertThat(result).as("返回false").isFalse();
    }

    @Test
    @DisplayName("检查循环队列是否已满，测试队列有k-1个元素的情况")
    void isFullIsFalse2() {
        for (int i = 1; i < k; i++) {
            queue.enQueue(i);
        }
        boolean result = queue.isFull();
        Assertions.assertThat(result).as("返回false").isFalse();
    }

    @Test
    @DisplayName("检查循环队列是否已满，测试队列有k个元素的情况,表示已满")
    void isFullIsTrue() {
        for (int i = 0; i < k; i++) {
            queue.enQueue(i);
        }
        boolean result = queue.isFull();
        Assertions.assertThat(result).as("返回true").isTrue();
    }

    @Test
    @DisplayName("检查循环队列是否已满，测试队列有k + N个元素的情况,表示已满")
    void isFullIsTrue1() {
        for (int i = 0; i < k + 3; i++) {
            queue.enQueue(i);
        }
        boolean result = queue.isFull();
        Assertions.assertThat(result).as("返回true").isTrue();
    }
}