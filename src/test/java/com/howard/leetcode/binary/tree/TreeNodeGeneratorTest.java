package com.howard.leetcode.binary.tree;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("生成一棵二叉树")
class TreeNodeGeneratorTest {

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试由List生成一棵二叉树")
    void generate(List<Integer> data) {
        TreeNode root = TreeNodeGenerator.generate(data);
        Assertions.assertThat(root).as("不为NULL").isNotNull();
        Assertions.assertThat(root.val).as("根节点的值为{}").isEqualTo(data.get(0));
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, null, 2, 3)),
                Arguments.arguments(Lists.newArrayList(1, null, 2, 3, 4, 5, 6)),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8)),
                Arguments.arguments(Lists.newArrayList(1))
        );
    }
}