package com.anonymouscorgi.karakoram.kb0550;

import static com.anonymouscorgi.karakoram.kb0550.LintCode587TwoSumUniquePairs.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LintCode587TwoSumUniquePairsTest {

  private static Stream<Arguments> generateTestParametersStream() {
    return Stream.of(
        arguments(
            /* nums= */ new int[]{1, 1, 2, 45, 46, 46},
            /* target= */ 47,
            /* expected= */ 2)
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void twoSum6(int[] nums, int target, int expected) {
    assertThat(TWO_SUM.twoSum6(nums, target)).isEqualTo(expected);
  }
}