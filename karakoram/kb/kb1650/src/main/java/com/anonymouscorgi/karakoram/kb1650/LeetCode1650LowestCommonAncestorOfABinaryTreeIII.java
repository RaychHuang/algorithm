package com.anonymouscorgi.karakoram.kb1650;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 1650. Lowest Common Ancestor of a Binary Tree III
 *
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 *
 * Each node will have a reference to its parent node. The definition for Node is below:
 */
interface LeetCode1650LowestCommonAncestorOfABinaryTreeIII {

  Node lowestCommonAncestor(Node p, Node q);

  LeetCode1650LowestCommonAncestorOfABinaryTreeIII LOOP_BFS = new LeetCode1650LowestCommonAncestorOfABinaryTreeIII() {

    @Override
    public Node lowestCommonAncestor(Node p, Node q) {
      Set<Node> visited = new HashSet<>();
      for (Node node = p; node != null; node = node.parent) {
        visited.add(node);
      }
      for (Node node = q; ; node = node.parent) {
        if (!visited.add(node)) {
          return node;
        }
      }
    }
  };

  class Node {

    public int val;
    public Node left;
    public Node right;
    public Node parent;
  }
}
