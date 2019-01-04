package com.howard.leetcode.binary.tree;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("序列化和反序列化")
class CodecTest {

    private Codec codec;

    @BeforeEach
    void setUp() {
        codec = new Codec();
    }

    @ParameterizedTest
    @MethodSource("providerSerialize")
    @DisplayName("序列化测试")
    void serialize(List<Integer> data, String rightResult) {
        String result = codec.serialize(TreeNodeGenerator.generate(data));
        Assertions.assertThat(result).isEqualTo(rightResult);
    }

    @ParameterizedTest
    @MethodSource("providerDeserialize")
    @DisplayName("反序列化测试")
    void deserialize(String data) {
        TreeNode result = codec.deserialize(data);
        Assertions.assertThat(result).isNotNull();

    }

    static Stream<Arguments> providerSerialize() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(1, 2, 3, null, null, 4, 5), "1,2,3,null,null,4,5,null,null,null,null")
        );
    }

    static Stream<Arguments> providerDeserialize() {
        return Stream.of(
                Arguments.arguments("1,2,3,null,null,4,5,null,null,null,null")
        );
    }
}