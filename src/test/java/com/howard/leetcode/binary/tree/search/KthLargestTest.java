package com.howard.leetcode.binary.tree.search;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("第K大的元素")
class KthLargestTest {

    private KthLargest kthLargest;

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试添加元素")
    void add(int k, int[] nums, List<Node> resultList) {
        kthLargest = new KthLargest(k, nums);
        resultList.forEach(result -> {
            int kVal = kthLargest.add(result.add);
            System.out.println(kVal);
            Assertions.assertThat(kVal)
                    .isEqualTo(result.right);
        });
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(3, new int[] {4, 5, 8, 2}
                , Lists.newArrayList(new Node(3, 4),
                                new Node(5, 5),
                                new Node(10, 5),
                                new Node(9, 8),
                                new Node(4, 8))),
                Arguments.arguments(1, new int[] {},
                        Lists.newArrayList(new Node(-3, -3),
                                new Node(-2, -2),
                                new Node(-4, -2),
                                new Node(0, 0),
                                new Node(4, 4))),
                Arguments.arguments(2, new int[] {0},
                        Lists.newArrayList(new Node(-1, -1),
                                new Node(1, 0),
                                new Node(-2, 0),
                                new Node(-4, 0),
                                new Node(3, 1)))
        );
    }

    private static class Node {
        int add;
        int right;

        public Node(int add, int right) {
            this.add = add;
            this.right = right;
        }
    }
}