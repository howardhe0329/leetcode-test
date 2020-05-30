package com.howard.leetcode.binary.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("二分查找求x的平方根")
class MySqrtDoubleSolutionTest {

    private MySqrtDoubleSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MySqrtDoubleSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("求x的平方根")
    void mySqrt(double x, double threshold, double before, double after) {
        double result = solution.mySqrt(x, threshold);
        Assertions.assertThat(result).isBetween(before, after);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(8.0, 1e-5, 2.828, Math.sqrt(8.0)),
                Arguments.arguments(4.0, 1e-5, 1.999, Math.sqrt(4.0))
        );
    }
}