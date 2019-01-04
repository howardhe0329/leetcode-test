package com.howard.leetcode.binary.tree.search;

import com.howard.leetcode.binary.tree.TreeNodeGenerator;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("验证是否为二叉搜索树")
class IsValidBinarySearchTreeSolutionTest {

    private IsValidBinarySearchTreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new IsValidBinarySearchTreeSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试是否为二叉搜索树")
    void isValidBST(List<Integer> data, boolean right) {
        boolean result = solution.isValidBST(TreeNodeGenerator.generate(data));
        Assertions.assertThat(result).as("结果正确").isEqualTo(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(2, 1, 3), true),
                Arguments.arguments(Lists.newArrayList(5, 1, 4, null, null, 3, 6), false),
                Arguments.arguments(Lists.newArrayList(1, 2, 3), false)
        );
    }
}