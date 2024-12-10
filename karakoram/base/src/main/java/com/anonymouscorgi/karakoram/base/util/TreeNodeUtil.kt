package com.anonymouscorgi.karakoram.base.util

import com.anonymouscorgi.karakoram.base.TreeNode
import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

object TreeNodeUtil {

  @JvmStatic
  fun serialize(root: TreeNode?): String =
    toIntList(root).joinToString(separator = ",", prefix = "[", postfix = "]")


  @JvmStatic
  fun deserialize(data: String?): TreeNode? {
    if (data == null || data.length < 3) {
      return null
    }
    return fromIntList(
      data.substring(1, data.lastIndex).split(",").map { if (it == "null") null else it.toInt() })
  }

  @JvmStatic
  fun toIntArray(root: TreeNode?): Array<Int?> = toIntList(root).toTypedArray()

  @JvmStatic
  fun toIntList(root: TreeNode?): List<Int?> {
    if (root == null) return listOf()

    val result = mutableListOf<Int?>()
    val queue: Queue<TreeNode?> = LinkedList<TreeNode?>().apply { offer(root) }
    while (queue.isNotEmpty()) {
      val node = queue.poll()
      result.add(node?.`val`)
      if (node != null) {
        queue.offer(node.left)
        queue.offer(node.right)
      }
    }
    while (result.isNotEmpty() && result.last() == null) result.removeLast()
    return result
  }

  @JvmStatic
  fun fromIntList(values: List<Int?>): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null

    val root = TreeNode(values[0]!!)
    val taskList: Queue<TreeNode> = LinkedList<TreeNode>().apply { offer(root) }
    var childIndex = 1
    while (taskList.isNotEmpty()) {
      val parentNode = taskList.poll()
      val endIndex = min(childIndex + 2, values.size)
      while (childIndex < endIndex) {
        val childVal = values[childIndex]
        if (childVal != null) {
          val childNode = TreeNode(childVal)
          if (childIndex % 2 == 1) {
            parentNode.left = childNode
          } else {
            parentNode.right = childNode
          }
          taskList.offer(childNode)
        }
        childIndex++
      }
    }
    return root
  }
}