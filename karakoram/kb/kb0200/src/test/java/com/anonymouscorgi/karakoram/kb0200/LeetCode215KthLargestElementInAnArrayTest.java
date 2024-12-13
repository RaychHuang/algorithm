package com.anonymouscorgi.karakoram.kb0200;

import static com.anonymouscorgi.karakoram.kb0200.LeetCode215KthLargestElementInAnArray.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LeetCode215KthLargestElementInAnArrayTest {

  private static Stream<Arguments> generateTestParametersStream() {
    return Stream.of(
        arguments(
            /* nums= */ new int[]{3, 2},
            /* k= */ 1,
            /* expected= */ 3),
        arguments(
            /* nums= */ new int[]{3, 2, 1, 5, 6, 4},
            /* k= */ 2,
            /* expected= */ 5),
        arguments(
            /* nums= */ new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6},
            /* k= */ 4,
            /* expected= */ 4)
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void findKthLargest(int[] nums, int k, int expected) {
    assertThat(Method.findKthLargest(nums, k)).isEqualTo(expected);
  }
}