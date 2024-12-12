package com.anonymouscorgi.karakoram.kb0500;

import com.anonymouscorgi.karakoram.annotation.Medium;
import java.util.Random;

/**
 * LeetCode 528. Random Pick with Weight
 *
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith
 * index.
 *
 * You need to implement the function pickIndex(), which randomly picks an index in the range [0,
 * w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] /
 * sum(w).
 *
 * For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%),
 * and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 */
@Medium
interface LeetCode528RandomPickWithWeight {

  public abstract int pickIndex();

  class Solution implements LeetCode528RandomPickWithWeight {

    private final int range;
    private final int[] weight;
    private final Random random;

    public Solution(int[] w) {
      weight = new int[w.length];
      weight[0] = w[0];
      for (int i = 1; i < w.length; i++) {
        weight[i] = weight[i - 1] + w[i];
      }
      range = weight[weight.length - 1];
      random = new Random();
    }

    @Override
    public int pickIndex() {
      int randomInRange = random.nextInt(range);
      return findFirst(weight, randomInRange);
    }

    private static int findFirst(int[] weight, int target) {
      int start = 0;
      int end = weight.length - 1;
      while (start < end) {
        int mid = start + (end - start) / 2;
        if (weight[mid] > target) {
          end = mid;
        } else {
          start = mid + 1;
        }
      }
      return weight[start] > target ? start : end;
    }
  }
}
