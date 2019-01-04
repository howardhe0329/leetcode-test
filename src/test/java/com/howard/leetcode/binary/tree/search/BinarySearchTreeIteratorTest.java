package com.howard.leetcode.binary.tree.search;

import com.howard.leetcode.binary.tree.TreeNodeGenerator;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("二叉搜索树迭代器")
class BinarySearchTreeIteratorTest {

    private BinarySearchTreeIterator iterator;

    @BeforeEach
    void setUp() {

    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试返回下一个节点")
    void next(List<Integer> data, List<Integer> rightList) {
        iterator = new BinarySearchTreeIterator(TreeNodeGenerator.generate(data));
        List<Integer> result = new ArrayList<>(data.size());
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        Assertions.assertThat(result).as("是否正确").containsAll(rightList);
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("测试是否有下一个节点")
    void hasNext(List<Integer> data) {
        iterator = new BinarySearchTreeIterator(TreeNodeGenerator.generate(data));
        iterator.next();
        iterator.next();
        boolean result = iterator.hasNext();
        Assertions.assertThat(result).isTrue();
        iterator.next();
        result = iterator.hasNext();
        Assertions.assertThat(result).isTrue();
        iterator.next();
        result = iterator.hasNext();
        Assertions.assertThat(result).isTrue();
        iterator.next();
        result = iterator.hasNext();
        Assertions.assertThat(result).isFalse();
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.arguments(Lists.newArrayList(7, 3, 15, null, null, 9, 20)
                    , Lists.newArrayList(3, 7, 9, 15, 20))
        );
    }
}