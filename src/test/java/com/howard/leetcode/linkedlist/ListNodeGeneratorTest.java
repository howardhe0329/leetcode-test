package com.howard.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeGeneratorTest {

    @Test
    @DisplayName("ListNode生成器测试")
    void generate() {
        Assertions.assertThat(ListNodeGenerator.generate(null))
            .as("返回null").isNull();
        Assertions.assertThat(ListNodeGenerator.generate(Lists.emptyList()))
                .as("返回null").isNull();
        ListNode head = ListNodeGenerator.generate(Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList()));
        Assertions.assertThat(head)
                .as("返回").isNotNull();
    }
}