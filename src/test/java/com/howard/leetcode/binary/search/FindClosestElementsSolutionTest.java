package com.howard.leetcode.binary.search;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("找到 K 个最接近的元素")
class FindClosestElementsSolutionTest {

    private FindClosestElementsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new FindClosestElementsSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试")
    void findClosestElements(int[] nums, int k, int x, List<Integer> right) {
        List<Integer> result = solution.findClosestElements(nums, k, x);
        Assertions.assertThat(result).containsSequence(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, 4, 3, Lists.newArrayList(1, 2, 3, 4)),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, 4, -1, Lists.newArrayList(1, 2, 3, 4)),
                Arguments.arguments(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5, Lists.newArrayList(3, 3, 4)),
                Arguments.arguments(new int[]{0,0,0,1,3,5,6,7,8,8}, 2, 2, Lists.newArrayList(1, 3))
        );
    }
}