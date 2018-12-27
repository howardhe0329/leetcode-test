package com.howard.leetcode.binary.tree;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("层次遍历二叉树")
class LevelOrderSolutionTest {

    private LevelOrderSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LevelOrderSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试层次遍历二叉树")
    void levelOrder(List<Integer> data) {
        List<List<Integer>> result = solution.levelOrder(TreeNodeGenerator.generate(data));
        System.out.println(result);
        Assertions.assertThat(result).as("不为NULL").isNotNull();
        Assertions.assertThat(result.stream().flatMap(Collection::stream).collect(Collectors.toList()))
                .as("包含元素").containsAll(data);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8))
        );
    }
}