package com.anonymouscorgi.karakoram.kb0100;

import static com.anonymouscorgi.karakoram.kb0100.LintCode136PalindoromePartitioning.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LintCode136PalindoromePartitioningTest {

  private static Stream<Arguments> generateTestParametersStream() {
    return Stream.of(
        arguments(
            /* s= */ "ab",
            /* expected= */ ImmutableList.of(ImmutableList.of("a", "b")))
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void partition(String s, List<List<String>> expected) {
    assertThat(DFS.partition(s)).containsExactlyElementsIn(expected);
  }
}