package com.howard.leetcode.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("字符串解码")
class DecodeStringSolutionTest {

    private DecodeStringSolution solution;

    @BeforeEach
    void setUp() {
        solution = new DecodeStringSolution();
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试字符串解码")
    void decodeString(String encode, String decode) {
        String result = solution.decodeString(encode);
        Assertions.assertThat(result).isEqualTo(decode);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments("3[a]2[bc]", "aaabcbc"),
                Arguments.arguments("3[a2[c]]", "accaccacc"),
                Arguments.arguments("2[abc]3[cd]ef", "abcabccdcdcdef")
        );
    }
}