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

@DisplayName("找出第一个错误的版本")
class VersionControlTest {

    private VersionControl versionControl;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("第一个错误的版本号")
    void firstBadVersion(int n, int first) {
        versionControl = new VersionControl(first);
        int result = versionControl.firstBadVersion(n);
        Assertions.assertThat(result).isEqualTo(first);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(5, 4),
                Arguments.arguments(5, 0),
                Arguments.arguments(5, 5)
        );
    }

    @Test
    @DisplayName("测试是否为错误的版本")
    void isBadVersion() {
        versionControl = new VersionControl(3);
        boolean result = versionControl.isBadVersion(3);
        Assertions.assertThat(result).isTrue();

        result = versionControl.isBadVersion(4);
        Assertions.assertThat(result).isTrue();

        result = versionControl.isBadVersion(5);
        Assertions.assertThat(result).isTrue();

        result = versionControl.isBadVersion(2);
        Assertions.assertThat(result).isFalse();
    }
}