package com.anonymouscorgi.karakoram.kb0000;

import static com.anonymouscorgi.karakoram.kb0000.LintCode036ReverseLinkedListII.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.anonymouscorgi.karakoram.base.ListNode;
import com.anonymouscorgi.karakoram.base.util.ListNodeUtil;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LintCode036ReverseLinkedListIITest {

  private static Stream<Arguments> generateTestParametersStream() {
    return Stream.of(
        arguments(
            /* head= */ ListNodeUtil.fromIntArray(new int[]{1, 2, 3, 4, 5}),
            /* m= */ 2,
            /* n= */ 2,
            /* expected= */ new int[]{1, 2, 3, 4, 5}),
        arguments(
            /* head= */ ListNodeUtil.fromIntArray(new int[]{1, 2, 3, 4, 5}),
            /* m= */ 1,
            /* n= */ 2,
            /* expected= */ new int[]{2, 1, 3, 4, 5}),
        arguments(
            /* head= */ ListNodeUtil.fromIntArray(new int[]{1, 2, 3, 4, 5}),
            /* m= */ 4,
            /* n= */ 5,
            /* expected= */ new int[]{1, 2, 3, 5, 4}),
        arguments(
            /* head= */ ListNodeUtil.fromIntArray(new int[]{1, 2, 3, 4, 5}),
            /* m= */ 2,
            /* n= */ 4,
            /* expected= */ new int[]{1, 4, 3, 2, 5}),
        arguments(
            /* head= */ ListNodeUtil.fromIntArray(new int[]{1, 2, 3, 4}),
            /* m= */ 2,
            /* n= */ 3,
            /* expected= */ new int[]{1, 3, 2, 4})
    );
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void reverseBetween_method1(ListNode head, int m, int n, int[] expected) {
    ListNode node = METHOD.reverseBetween(head, m, n);
    assertThat(ListNodeUtil.hasCycle(node)).isFalse();
    assertThat(ListNodeUtil.toIntArray(node)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  void reverseBetween_method2(ListNode head, int m, int n, int[] expected) {
    ListNode node = METHOD2.reverseBetween(head, m, n);
    assertThat(ListNodeUtil.hasCycle(node)).isFalse();
    assertThat(ListNodeUtil.toIntArray(node)).isEqualTo(expected);
  }
}