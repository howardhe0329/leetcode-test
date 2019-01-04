package com.howard.leetcode.binary.tree;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.omg.CORBA.DATA_CONVERSION;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("每个节点右向指针")
class ConnectSolutionTest {

    private ConnectSolution solution;

    @BeforeEach
    void setUp() {
        solution = new ConnectSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试每个节点右向指针")
    void connect(List<Integer> data) {
        TreeLinkNode root = TreeLinkNodeGenerator.generate(data);
        solution.connect(root);
        Assertions.assertThat(root).as("不为NULL").isNotNull();
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7))
        );
    }
}