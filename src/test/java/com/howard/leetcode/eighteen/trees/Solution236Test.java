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

class Solution236Test {

    private Solution236 solution;

    @ParameterizedTest
    @MethodSource("lowestCommonAncestorProvider")
    @DisplayName("LowestCommonAncestor")
    void LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, int right) {
        solution = new Solution236();
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        assertThat(result.val).isEqualTo(right);
    }

    static Stream<Arguments> lowestCommonAncestorProvider() {
        TreeNode root = TreeNodeGenerator.generate(Lists.newArrayList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        return Stream.of(
                Arguments.arguments(root, root.left, root.right, 3),
                Arguments.arguments(root, root.left, root.left.right.right, 5),
                Arguments.arguments(root, root.left.right.left, root.right.right, 3)
        );
    }
}