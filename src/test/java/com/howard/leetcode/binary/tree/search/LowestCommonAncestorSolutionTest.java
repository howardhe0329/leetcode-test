package com.howard.leetcode.binary.tree.search;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeGenerator;
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

@DisplayName("二叉搜索树的最近公共祖先")
class LowestCommonAncestorSolutionTest {

    private LowestCommonAncestorSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LowestCommonAncestorSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("找出共同祖先")
    void lowestCommonAncestor(List<Integer> data, int pVal, int qVal, int rightVal) {
        TreeNode root = TreeNodeGenerator.generate(data);
        TreeNode p = order(root, pVal);
        TreeNode q = order(root, qVal);
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.val).isEqualTo(rightVal);
    }

    private TreeNode order(TreeNode n, int val) {
        if (n == null) {
            return null;
        }
        if (n.val == val) {
            return n;
        }
        TreeNode l = order(n.left, val);
        TreeNode r = order(n.right, val);
        if (l != null) {
            return l;
        }
        if (r != null) {
            return r;
        }
        return null;
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(6,2,8,0,4,7,9,null,null,3,5), 2, 8, 6),
                Arguments.arguments(Lists.newArrayList(6,2,8,0,4,7,9,null,null,3,5), 2, 4, 2)

        );
    }
}