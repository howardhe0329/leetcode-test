package com.howard.leetcode.binary.tree.balance;

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

@DisplayName("验证二叉树是否为平衡二叉树")
class IsBalancedSolutionTest {

    private IsBalancedSolution solution;

    @BeforeEach
    void setUp() {
        solution = new IsBalancedSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("是否平衡")
    void isBalanced(List<Integer> data, boolean right) {
        boolean result = solution.isBalanced(TreeNodeGenerator.generate(data));
        Assertions.assertThat(result).as("").isEqualTo(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(3, 9, 20, null, null, 15, 7), true),
                Arguments.arguments(Lists.newArrayList(1, 2, 2, 3, 3, null, null, 4, 4), false),
                Arguments.arguments(Lists.newArrayList(1,2,2,3,null,null,3,4,null,null,4), false),
                Arguments.arguments(Lists.newArrayList(4, 1, 2, 5, 6, 11, 12, null, null, 7, 8, 15, 16, 13, 14, 9, 10, null, null, 17, 18, null, null, null, null, null, null, null, 19), false)
        );
    }
}