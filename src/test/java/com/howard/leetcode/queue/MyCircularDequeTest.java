package com.howard.leetcode.queue;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MyCircularDequeTest {

    private MyCircularDeque myCircularDeque;

    @BeforeEach
    void setUp() {
        myCircularDeque = new MyCircularDeque(5);
    }

    @Test
    @DisplayName("InsertFront")
    void InsertFront() {
        int val = 4;
        assertThat(myCircularDeque.isEmpty()).isTrue();
        assertThat(myCircularDeque.isFull()).isFalse();
        myCircularDeque.insertFront(val);
        assertThat(myCircularDeque.getFront()).isEqualTo(val);
        assertThat(myCircularDeque.getRear()).isEqualTo(val);
        assertThat(myCircularDeque.isEmpty()).isFalse();
        assertThat(myCircularDeque.isFull()).isFalse();

        myCircularDeque.insertFront(val = 1);
        assertThat(myCircularDeque.getFront()).isEqualTo(val);
        assertThat(myCircularDeque.isFull()).isFalse();
        myCircularDeque.insertFront(val = 2);
        assertThat(myCircularDeque.getFront()).isEqualTo(val);
        assertThat(myCircularDeque.isFull()).isFalse();
        myCircularDeque.insertFront(val = 3);
        assertThat(myCircularDeque.getFront()).isEqualTo(val);
        assertThat(myCircularDeque.isFull()).isFalse();
        myCircularDeque.insertFront(val = 5);
        assertThat(myCircularDeque.getFront()).isEqualTo(val);
        assertThat(myCircularDeque.isFull()).isTrue();
    }

    @Test
    @DisplayName("InsertLast")
    void InsertLast() {
        int val = 4;
        assertThat(myCircularDeque.isEmpty()).isTrue();
        assertThat(myCircularDeque.isFull()).isFalse();
        myCircularDeque.insertFront(val);
        assertThat(myCircularDeque.getFront()).isEqualTo(val);
        assertThat(myCircularDeque.getRear()).isEqualTo(val);
        assertThat(myCircularDeque.isEmpty()).isFalse();
        assertThat(myCircularDeque.isFull()).isFalse();

        myCircularDeque.insertLast(val = 1);
        assertThat(myCircularDeque.getRear()).isEqualTo(val);
        assertThat(myCircularDeque.isFull()).isFalse();

        myCircularDeque.insertFront(val = 2);
        assertThat(myCircularDeque.getFront()).isEqualTo(val);
        assertThat(myCircularDeque.isFull()).isFalse();

        myCircularDeque.insertLast(val = 3);
        assertThat(myCircularDeque.getRear()).isEqualTo(val);
        assertThat(myCircularDeque.isFull()).isFalse();

        myCircularDeque.insertLast(val = 5);
        assertThat(myCircularDeque.getRear()).isEqualTo(val);
        assertThat(myCircularDeque.isFull()).isTrue();
    }

    @Test
    @DisplayName("DeleteFront")
    void DeleteFront() {
    }

    @Test
    @DisplayName("DeleteLast")
    void DeleteLast() {
    }

    @Test
    @DisplayName("GetFront")
    void GetFront() {
    }

    @Test
    @DisplayName("GetRear")
    void GetRear() {
    }

    @Test
    @DisplayName("IsEmpty")
    void IsEmpty() {
    }

    @Test
    @DisplayName("IsFull")
    void IsFull() {
    }

    @Test
    @DisplayName("Main")
    void Main() {
    }
}