package com.anonymouscorgi.karakoram.kb1200;

import com.anonymouscorgi.karakoram.annotation.Medium;

/**
 * LeetCode 1249. Minimum Remove to Make Valid Parentheses
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that
 * the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or It can be written as AB (A
 * concatenated with B), where A and B are valid strings, or It can be written as (A), where A is a
 * valid string.
 */
@Medium
interface LeetCode1249MinimumRemoveToMakeValidParentheses {

  String minRemoveToMakeValid(String s);

  LeetCode1249MinimumRemoveToMakeValidParentheses Greedy = new LeetCode1249MinimumRemoveToMakeValidParentheses() {

    @Override
    public String minRemoveToMakeValid(String s) {
      if (s.isEmpty()) {
        return s;
      }
      StringBuilder sb = new StringBuilder();
      int openCount = 0;

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') {
          openCount++;
        } else if (c == ')') {
          openCount--;
        }

        if (openCount >= 0) {
          sb.append(c);
        } else {
          openCount = 0;
        }
      }

      int closeCount = 0;
      s = sb.toString();
      sb.delete(0, sb.length());
      for (int i = s.length() - 1; i >= 0; i--) {
        char c = s.charAt(i);
        if (c == ')') {
          closeCount++;
        } else if (c == '(') {
          closeCount--;
        }

        if (closeCount >= 0) {
          sb.append(c);
        } else {
          closeCount = 0;
        }
      }

      return sb.reverse().toString();
    }
  };
}
