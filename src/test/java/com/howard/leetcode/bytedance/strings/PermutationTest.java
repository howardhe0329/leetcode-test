package com.howard.leetcode.bytedance.strings;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class PermutationTest {

    private Permutation permutation;

    @ParameterizedTest
    @MethodSource("permuteProvider")
    @DisplayName("Permute")
    void Permute(String str, List<String> rightList) {
        permutation = new Permutation();
        List<String> resultList = permutation.permute(str);
        assertThat(resultList).containsAll(rightList);
    }

    static Stream<Arguments> permuteProvider() {
        return Stream.of(
                Arguments.arguments("ab", Lists.newArrayList("ab", "ba")),
                Arguments.arguments("abc", Lists.newArrayList("abc", "acb", "bac", "bca", "cab", "cba"))
        );
    }
}