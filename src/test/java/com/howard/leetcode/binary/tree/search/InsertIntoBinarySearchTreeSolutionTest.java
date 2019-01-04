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

@DisplayName("插入二叉搜索树中")
class InsertIntoBinarySearchTreeSolutionTest {

    private InsertIntoBinarySearchTreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new InsertIntoBinarySearchTreeSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试插入操作")
    void insertIntoBST(List<Integer> data, int val) {
        TreeNode result = solution.insertIntoBST(TreeNodeGenerator.generate(data), val);
        Assertions.assertThat(result).isNotNull();
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(4, 2, 7, 1, 3), 5)
        );
    }
}