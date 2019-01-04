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

@DisplayName("搜索二叉搜索树中的节点")
class SearchBinarySearchTreeSolutionTest {

    private SearchBinarySearchTreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SearchBinarySearchTreeSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("搜索")
    void searchBSTisNotNull(List<Integer> data, int val) {
        TreeNode result = solution.searchBST(TreeNodeGenerator.generate(data), val);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.val).isEqualTo(val);
    }

    @ParameterizedTest
    @MethodSource("providerIsNull")
    @DisplayName("搜索")
    void searchBSTisNull(List<Integer> data, int val) {
        TreeNode result = solution.searchBST(TreeNodeGenerator.generate(data), val);
        Assertions.assertThat(result).isNull();
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(4, 2, 7, 1, 3), 2)
        );
    }

    static Stream<Arguments> providerIsNull() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(2, 1, 3), 5)
        );
    }
}