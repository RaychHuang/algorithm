package com.anonymouscorgi.karakoram.kb0000;

import static com.anonymouscorgi.karakoram.kb0000.LintCode017LetterCombinationsOfPhoneNumber.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LintCode017LetterCombinationsOfPhoneNumberTest {

  private static Stream<Arguments> generateTestParametersStream() {
    return Stream.of(
        arguments(
            /* digits= */  "23",
            /* expected= */ ImmutableList.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void letterCombinations(String digits, List<String> expected) {
    assertThat(DFS.letterCombinations(digits)).containsExactlyElementsIn(expected);
  }
}