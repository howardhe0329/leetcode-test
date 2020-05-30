package com.howard.leetcode.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RK算法")
class RabinKarpTest {

    private RabinKarp rk;

    @BeforeEach
    void setUp() {
        rk = new RabinKarp();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试RK算法")
    void indexOf(String main, String sub, int right) {
        int result = rk.indexOf(main, sub);
        Assertions.assertThat(result).isEqualTo(right);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments("hello", "lo", 3),
                Arguments.arguments("", "", -1),
                Arguments.arguments("hello", "he", 0),
                Arguments.arguments("hello", "ell", 1),
                Arguments.arguments("hello", "elle", -1)
        );
    }
}