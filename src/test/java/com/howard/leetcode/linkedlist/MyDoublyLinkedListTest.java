package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("双链表")
class MyDoublyLinkedListTest {

    private MyDoublyLinkedList<Integer> myDoublyLinkedList;

    @BeforeEach
    void setUp() {
        myDoublyLinkedList = new MyDoublyLinkedList<>();
    }

    @ParameterizedTest
    @CsvSource("0, 1, 2, 3")
    @DisplayName("获取一个节点")
    void getThrowsException(int index) {
        Assertions.assertThatThrownBy(() -> myDoublyLinkedList.get(index))
                .as("超出范围")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("参数无效, 超出范围");
    }

    @ParameterizedTest
    @CsvSource("0")
    @DisplayName("获取一个节点")
    void get(int index) {
        Assertions.assertThatThrownBy(() -> myDoublyLinkedList.get(index))
                .as("超出范围")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("参数无效, 超出范围");
    }


    @ParameterizedTest
    @CsvSource("1")
    @DisplayName("在链表的头部插入节点")
    void addAtHead(int val) {
        myDoublyLinkedList.addAtHead(val);
        Integer result = myDoublyLinkedList.get(0);
        Assertions.assertThat(result).isEqualTo(val);
        myDoublyLinkedList.addAtHead(val);
        result = myDoublyLinkedList.get(0);
        Assertions.assertThat(result).isEqualTo(val);
        result = myDoublyLinkedList.get(1);
        Assertions.assertThat(result).isEqualTo(val);
    }

    @ParameterizedTest
    @CsvSource("1")
    @DisplayName("在链表的尾部插入节点")
    void addAtTail(int val) {
        myDoublyLinkedList.addAtTail(val);
        Integer result = myDoublyLinkedList.get(0);
        Assertions.assertThat(result).isEqualTo(val);
        myDoublyLinkedList.addAtTail(val);
        result = myDoublyLinkedList.get(0);
        Assertions.assertThat(result).isEqualTo(val);
        result = myDoublyLinkedList.get(1);
        Assertions.assertThat(result).isEqualTo(val);
    }

    @ParameterizedTest
    @CsvSource("0, 2")
    @DisplayName("在链表的指定位置前插入节点")
    void addAtIndex(int index, int val) {
        myDoublyLinkedList.addAtIndex(index, val);
        Integer result = myDoublyLinkedList.get(0);
        Assertions.assertThat(result).isEqualTo(val);
        myDoublyLinkedList.addAtIndex(index, val);
        result = myDoublyLinkedList.get(0);
        Assertions.assertThat(result).isEqualTo(val);
        result = myDoublyLinkedList.get(1);
        Assertions.assertThat(result).isEqualTo(val);
    }

    @ParameterizedTest
    @CsvSource("")
    @DisplayName("在链表的指定位置删除元素")
    void deleteAtIndex() {
    }
}