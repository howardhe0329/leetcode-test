package com.howard.leetcode.binary.tree;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("后序遍历二叉树")
class PostorderTraversalSolutionTest {

    private PostorderTraversalSolution solution;

    @BeforeEach
    void setUp() {
        solution = new PostorderTraversalSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试后序遍历二叉树")
    void postorderTraversal(List<Integer> data) {
        List<Integer> result = solution.postorderTraversal(TreeNodeGenerator.generate(data));
        System.out.println(result);
        Assertions.assertThat(result).as("不为NULL").isNotNull()
                .as("包含元素").containsAll(data.stream().filter(Objects::nonNull).collect(Collectors.toList()));
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, null, 2, 3)),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8))
        );
    }
}