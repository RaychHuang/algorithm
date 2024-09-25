package com.anonymouscorgi.karakoram.kb0450;

import static com.anonymouscorgi.karakoram.kb0450.LintCode461KthSmallestNumberInUnsortedArray.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LintCode461KthSmallestNumberInUnsortedArrayTest {

  private static Stream<Arguments> generateTestParametersStream() {
    return Stream.of(
        // arguments(
        //     /* k= */ 3,
        //     /* nums= */ new int[]{3, 4, 1, 2, 5},
        //     /* expected= */ 3),
        arguments(
            /* k= */ 3,
            /* nums= */ new int[]{1, 3, 4, 5, 2},
            /* expected= */ 3)
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void kthSmallest(int k, int[] nums, int expected) {
    assertThat(PARTITION.kthSmallest(k, nums)).isEqualTo(expected);
  }
}