package com.anonymouscorgi.karakoram.kb0100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LintCode 138 · Subarray Sum
 * <p>
 * Given an integer array, find a subarray where the sum of numbers is zero. Your code should return
 * the index of the first number and the index of the last number.
 */
interface LintCode138SubarraySum {

  List<Integer> subarraySum(int[] nums);

  LintCode138SubarraySum METHOD = new LintCode138SubarraySum() {

    @Override
    public List<Integer> subarraySum(int[] nums) {
      if (nums == null || nums.length == 0) {
        return Collections.emptyList();
      }

      List<Integer> result = new ArrayList<>();
      Map<Integer, Integer> sumRecord = new HashMap<>();
      sumRecord.put(0, -1);

      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sumRecord.containsKey(sum)) {
          result.add(sumRecord.get(sum) + 1);
          result.add(i);
          break;
        }
        sumRecord.put(sum, i);
      }
      return result;
    }
  };
}
