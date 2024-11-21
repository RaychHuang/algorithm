package com.anonymouscorgi.karakoram.base.util

import com.anonymouscorgi.karakoram.base.ListNode

object ListNodeUtil {

  /**
   * Converts an integer array to a singly linked list.
   *
   * Each element of the array becomes a node in the linked list, with the array's
   * last element becoming the head of the list.
   *
   * @param arr the integer array to convert, or null if there is no input.
   * @return the head of the linked list, or null if the array is empty or null.
   */
  @JvmStatic
  fun fromIntArray(arr: IntArray?): ListNode? {
    arr ?: return null
    var current: ListNode? = null
    for (i in arr.size - 1 downTo 0) {
      current = ListNode(arr[i]).apply { next = current }
    }
    return current
  }

  /**
   * Converts the linked list starting from this node into an integer array.
   *
   * Each node's value will become an element in the array, preserving the order
   * of the linked list. The head node's value will be the first element of the array.
   *
   * @return an integer array representing the values of the linked list nodes.
   */
  @JvmStatic
  fun ListNode.toIntArray(): IntArray {
    val values = mutableListOf<Int>()
    var current: ListNode? = this
    while (current != null) {
      values.add(current.`val`)
      current = current.next
    }
    return values.toIntArray()
  }

  /**
   * Detects if the linked list has a cycle.
   *
   * Uses Floyd's Tortoise and Hare algorithm to determine if there is a cycle.
   * It prints out a message indicating whether the linked list has a cycle.
   *
   * @return true if the linked list contains a cycle, false otherwise.
   */
  @JvmStatic
  fun ListNode?.hasCycle(): Boolean {
    var slow: ListNode? = this
    var fast: ListNode? = this

    while (fast?.next != null) {
      slow = slow?.next
      fast = fast.next?.next

      if (slow == fast) {
        return true
      }
    }
    return false
  }

  /**
   * Returns a string representation of the linked list starting from this node.
   *
   * The string follows the format "[val1->val2->...->valN]" where val1 is the
   * value of the head node and valN is the value of the last node in the list.
   *
   * @return a string representation of the linked list.
   */
  @JvmStatic
  fun ListNode.print() {
    val positionMap = mutableMapOf<ListNode, Int>()
    var positionIndex = 0;
    val str = StringBuilder().append('[')

    positionMap[this] = positionIndex++
    str.append(`val`)
    var nextNode: ListNode? = this.next
    while (nextNode != null) {
      if (positionMap.containsKey(nextNode)) {
        str.append("->").append("'${positionMap[nextNode]}'")
        break
      } else {
        positionMap[nextNode] = positionIndex++
        str.append("->").append(nextNode.`val`)
        nextNode = nextNode.next
      }
    }
    print(str.append(']').toString())
  }
}