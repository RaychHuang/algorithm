package com.anonymouscorgi.karakoram.kb0000;

import com.anonymouscorgi.karakoram.base.ListNode;

/**
 * LintCode 36 · Reverse Linked List II
 *
 * Description
 *
 * Reverse a linked list from position m to n.
 *
 * Example 1:
 *
 * Input: linked list = 1->2->3->4->5->NULL m = 2 n = 4
 *
 * Output: 1->4->3->2->5->NULL Explanation:
 *
 * Reverse the [2,4] position of the linked list.
 *
 * Example 2:
 *
 * Input: linked list = 1->2->3->4->null m = 2 n = 3
 *
 * Output: 1->3->2->4->NULL Explanation:
 *
 * Reverse the [2,3] position of the linked list.
 */
interface LintCode036ReverseLinkedListII {

  ListNode reverseBetween(ListNode head, int m, int n);

  LintCode036ReverseLinkedListII METHOD = new LintCode036ReverseLinkedListII() {

    @Override
    public ListNode reverseBetween(ListNode head, int m, int n) {
      if (head == null) {
        return head;
      }

      ListNode stubNode = new ListNode(0);
      stubNode.next = head;
      ListNode iNode = stubNode;

      // Move prev to the node before m
      for (int i = 1; i < m; i++) {
        iNode = iNode.next;
      }
      ListNode mPrevNode = iNode;
      ListNode mNode = iNode = iNode.next;

      ListNode iPrevNode = iNode;
      iNode = iNode.next;
      ListNode iNextNode;
      for (int i = m + 1; i <= n; i++) {
        iNextNode = iNode.next;
        iNode.next = iPrevNode;
        iPrevNode = iNode;
        iNode = iNextNode;
      }

      mNode.next = iNode;
      mPrevNode.next = iPrevNode;

      return stubNode.next;
    }
  };

  LintCode036ReverseLinkedListII METHOD2 = new LintCode036ReverseLinkedListII() {

    @Override
    public ListNode reverseBetween(ListNode head, int m, int n) {
      if (head == null || m == n) {
        return head;
      }

      // Create a dummy node to simplify edge cases
      ListNode headReference = new ListNode(0);
      headReference.next = head;
      ListNode cursor = headReference;

      // Move prev to the node before m
      for (int i = 1; i < m; i++) {
        cursor = cursor.next;
      }

      // Start reversing from m to n
      ListNode current = cursor.next;
      ListNode next = null;
      ListNode tail = current;

      for (int i = 0; i < n - m; i++) {
        next = current.next;
        current.next = next.next;
        next.next = cursor.next;
        cursor.next = next;
      }

      return headReference.next;
    }
  };
}
