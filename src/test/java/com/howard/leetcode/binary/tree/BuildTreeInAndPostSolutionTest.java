package com.howard.leetcode.binary.tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("从中序与后序遍历序列构造二叉树")
class BuildTreeInAndPostSolutionTest {

    private BuildTreeInAndPostSolution solution;

    @BeforeEach
    void setUp() {
        solution = new BuildTreeInAndPostSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试")
    void buildTree(int[] inorder, int[] postorder) {
        TreeNode result = solution.buildTree(inorder, postorder);
        Assertions.assertThat(result).isNotNull();

    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[] {9,3,15,20,7},
                        new int[] {9,15,7,20,3})
        );
    }
}