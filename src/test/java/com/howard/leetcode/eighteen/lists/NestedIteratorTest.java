package com.howard.leetcode.eighteen.lists;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("扁平化嵌套列表迭代器")
class NestedIteratorTest {

    private NestedIterator iterator;

    @ParameterizedTest
    @MethodSource("hasNextProvider")
    @DisplayName("HasNext")
    void hasNext(List<NestedInteger> list, int[] right) {
        iterator = new NestedIterator(list);
        int i = 0;
        while (iterator.hasNext()) {
            Integer n = iterator.next();
            assertThat(n).isEqualTo(right[i++]);
        }
    }

    static Stream<Arguments> hasNextProvider() {
        List<NestedIterator> list = Lists.newArrayList();
        return Stream.of(
                Arguments.arguments(list, new int[0])
        );
    }

}