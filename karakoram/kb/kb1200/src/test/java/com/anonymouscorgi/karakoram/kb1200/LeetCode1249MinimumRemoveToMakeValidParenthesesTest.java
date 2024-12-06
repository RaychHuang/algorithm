package com.anonymouscorgi.karakoram.kb1200;

import static com.anonymouscorgi.karakoram.kb1200.LeetCode1249MinimumRemoveToMakeValidParentheses.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LeetCode1249MinimumRemoveToMakeValidParenthesesTest {

  private static Stream<Arguments> generateTestParametersStream() {
    return Stream.of(
        arguments(
            /* s= */ "lee(t(c)o)de)",
            /* expected= */ Arrays.asList("lee(t(c)o)de", "lee(t(co)de)", "lee(t(c)ode)")),
        arguments(
            /* s= */ "a)b(c)d",
            /* expected= */ Arrays.asList("ab(c)d")),
        arguments(
            /* s= */  "))((",
            /* expected= */ Arrays.asList(""))
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void minRemoveToMakeValid_greedy(String s, List<String> expected) {
    assertThat(Greedy.minRemoveToMakeValid(s)).isIn(expected);
  }
}