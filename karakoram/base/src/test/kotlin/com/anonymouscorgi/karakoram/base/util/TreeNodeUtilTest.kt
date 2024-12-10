package com.anonymouscorgi.karakoram.base.util

import com.anonymouscorgi.karakoram.base.TreeNode
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.params.provider.Arguments.arguments

import java.util.stream.Stream
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TreeNodeUtilTest {
  companion object {

    @JvmStatic
    fun generateTestParametersStream(): Stream<Arguments> {
      return Stream.of(
        arguments(
          /* org= */ intArrayOf(1, 2, 3),
          /* seqs= */ arrayOf<IntArray>(intArrayOf(1, 2), intArrayOf(1, 3)),
          /* expected= */ false
        )
      )
    }
  }

  @ParameterizedTest
  @MethodSource("generateTestParametersStream")
  fun serialize2() {
  }

  @Test
  fun serialize() {
    // 3,9,20,null,null,15,7
    val root = null

    val str = TreeNodeUtil.serialize(root)

    assertThat(str).isEqualTo("[]")
  }

  @Test
  fun serialize3() {
    // 3,9,20,null,null,15,7
    val root = TreeNode(3).apply {
      left = TreeNode(9)
      right = TreeNode(20).apply {
        left = TreeNode(15)
        right = TreeNode(7)
      }
    }

    val str = TreeNodeUtil.serialize(root)

    assertThat(str).isEqualTo("[3,9,20,null,null,15,7]")
  }

  @Test
  fun deserialize() {
    val originalString = "[3,9,20,null,null,15,7]"
    val root = TreeNodeUtil.deserialize("[3,9,20,null,null,15,7]")
    val recreatedString = TreeNodeUtil.serialize(root)

    assertThat(recreatedString).isEqualTo(originalString)
  }
}