package com.howard.leetcode.binary.tree;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("每个节点的右向指针II")
class ConnectSolutionIITest {

    private ConnectSolutionII solutionII;

    @BeforeEach
    void setUp() {
        solutionII = new ConnectSolutionII();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试每个节点的右向指针II")
    void connect(List<Integer> data) {
        TreeLinkNode root = TreeLinkNodeGenerator.generate(data);
        solutionII.connect(root);
        Assertions.assertThat(root).as("不为NULL").isNotNull();
    }

    static Stream<Arguments> provider() {
        return Stream.of(
//                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5, null, 7)),
                Arguments.arguments(Lists.newArrayList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8))
        );
    }
}