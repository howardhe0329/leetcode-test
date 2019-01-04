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

@DisplayName("删除二叉搜索树中的一个节点")
class DeleteBinarySearchTreeSolutionTest {

    private DeleteBinarySearchTreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new DeleteBinarySearchTreeSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("删除节点")
    void deleteNode(List<Integer> data, int key) {
        TreeNode result = solution.deleteNode(TreeNodeGenerator.generate(data), key);
        Assertions.assertThat(result).isNotNull();
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(5,3,6,2,4,null,7), 3)
        );
    }
}