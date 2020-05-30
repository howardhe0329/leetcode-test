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

@DisplayName("猜数字游戏")
class GuessGameTest {

    private GuessGame guessGame;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("猜数字")
    void guessNumber(int guess, int init) {
        guessGame = new GuessGame(guess);
        int result = guessGame.guessNumber(init);
        Assertions.assertThat(result).isEqualTo(guess);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(6, 10)
        );
    }

    @Test
    void guess() {
    }
}