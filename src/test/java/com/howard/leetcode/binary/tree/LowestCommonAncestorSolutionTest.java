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
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("二叉树最近的公共祖先")
class LowestCommonAncestorSolutionTest {

    private LowestCommonAncestorSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LowestCommonAncestorSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("找出最近公共祖先")
    void lowestCommonAncestor(List<Integer> data, int right) {
        TreeNode root = TreeNodeGenerator.generate(data);
        TreeNode p = null;
        TreeNode q = null;
        TreeNode n = root;
        if (n != null) {
            p = n.left;
            q = n.right;
        }
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.val).isEqualTo(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(3,5,1,6,2,0,8,null,null,7,4), 3)
        );
    }
}