package com.howard.leetcode.array;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("统计数组中的逆序对数量")
class ReverseOrderArrayTest {

    private ReverseOrderArray reverseOrderArray;

    @BeforeEach
    void setUp() {
        reverseOrderArray = new ReverseOrderArray();
    }

    @ParameterizedTest
    @MethodSource("countReverseOrderProvider")
    @DisplayName("CountReverseOrder")
    void CountReverseOrder(int[] nums, int target) {
        int result = reverseOrderArray.countReverseOrder(nums);
        assertThat(result).isEqualTo(target);
    }

    static Stream<Arguments> countReverseOrderProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 3, 5, 2, 4, 6}, 3)
        );
    }
}