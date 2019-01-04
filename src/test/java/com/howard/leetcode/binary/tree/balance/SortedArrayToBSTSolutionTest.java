package com.howard.leetcode.binary.tree.balance;

import com.howard.leetcode.binary.tree.TreeNode;
import com.howard.leetcode.binary.tree.TreeNodeOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("将有序数组转换为二叉搜索树")
class SortedArrayToBSTSolutionTest {

    private SortedArrayToBSTSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SortedArrayToBSTSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("将有序数组转换为二叉搜索树")
    void sortedArrayToBST(int[] nums) {
        TreeNode result = solution.sortedArrayToBST(nums);
        Assertions.assertThat(result).isNotNull();
        TreeNodeOrder order = new TreeNodeOrder();
        List<Integer> resultList = order.inOrder(result);
        Assertions.assertThat(resultList.toArray(new Integer[0])).isIn(nums);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[]{-10, -3, 0, 5, 9})
        );
    }
}