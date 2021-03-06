package com.howard.leetcode.eighteen.trees;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution230_2Test {

    private Solution230_2 solution;

    @ParameterizedTest
    @MethodSource("kthSmallestProvider")
    @DisplayName("KthSmallest")
    void KthSmallest(TreeNode root, int k, int right) {
        solution = new Solution230_2();
        int result = solution.kthSmallest(root, k);
        assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> kthSmallestProvider() {
        return Stream.of(
                Arguments.arguments(TreeNodeGenerator.generate(Lists.newArrayList(3, 1, 4, null, 2)), 1, 1),
                Arguments.arguments(TreeNodeGenerator.generate(Lists.newArrayList(5, 3, 6, 2, 4, null, null, 1)), 3, 3)
        );
    }
}