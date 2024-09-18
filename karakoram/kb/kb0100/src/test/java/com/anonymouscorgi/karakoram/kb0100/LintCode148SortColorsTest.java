package com.anonymouscorgi.karakoram.kb0100;

import static com.anonymouscorgi.karakoram.kb0100.LintCode148SortColors.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LintCode148SortColorsTest {

  private static Stream<Arguments> generateTestParametersStream() {
    return Stream.of(
        arguments(
            /* org= */ new int[]{2, 0, 0, 1, 2, 0, 2},
            /* expected= */ new int[]{0, 0, 0, 1, 2, 2, 2}
        )
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void sortColors(int[] nums,int[] expected) {
    QUICK_SORT.sortColors(nums);

    assertThat(nums).isEqualTo(expected);
  }
}