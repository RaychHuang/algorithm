package com.anonymouscorgi.karakoram.kb0050;

import static com.anonymouscorgi.karakoram.kb0050.LintCode065MedianOfTwoSortedArrays.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LintCode065MedianOfTwoSortedArraysTest {

  private static Stream<Arguments> generateTestParametersStream() {
    return Stream.of(
        arguments(
            /* a= */ new int[]{1, 2, 3, 4, 5, 6},
            /* b= */ new int[]{1, 2},
            /* expected= */ 2.5d)
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void findMedianSortedArrays_log(int[] a, int[] b, double expected) {
    assertThat(LOG.findMedianSortedArrays(a, b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void findMedianSortedArrays_linear(int[] a, int[] b, double expected) {
    assertThat(LINEAR.findMedianSortedArrays(a, b)).isEqualTo(expected);
  }
}