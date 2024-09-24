package com.anonymouscorgi.karakoram.kb0100;

import static com.anonymouscorgi.karakoram.kb0100.LintCode101RemoveDuplicatesfromSortedArrayII.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LintCode101RemoveDuplicatesfromSortedArrayIITest {

  private static Stream<Arguments> generateTestParametersStream() {
    return Stream.of(
        arguments(
            /* nums= */ new int[]{-14,-14,-14,-14,-14,-14,-14,-13,-13,-13,-13,-12,-11,-11,-11,-9,-9,-9,-7,-7,-7,-6,-6,-5,-5,-5,-4,-4,-4,-3,-3,-3,-2,-2,-2,-1,-1,0,0,0,0,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,5,5,6,6,6,7,7,7,7,8,8,8,8,9,9,10,10,11,11,11,11,11,12,12,12,12,13,13,13,13,14,14,15,16,17,18,18,18,20,20,21,21,21,21,21,22,22,22,22,23,24,24,25},
            /* expected= */ new int[]{-14,-14,-13,-13,-12,-11,-11,-9,-9,-7,-7,-6,-6,-5,-5,-4,-4,-3,-3,-2,-2,-1,-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12,13,13,14,14,15,16,17,18,18,20,20,21,21,22,22,23,24,24,25})
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void removeDuplicates(int[] nums, int[] expected) {
    int len = TWO_POINTERS.removeDuplicates(nums);
    assertThat(Arrays.copyOf(nums, len)).isEqualTo(expected);
  }
}