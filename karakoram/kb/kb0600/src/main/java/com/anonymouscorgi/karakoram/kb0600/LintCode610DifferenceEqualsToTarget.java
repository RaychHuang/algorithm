package com.anonymouscorgi.karakoram.kb0600;

import java.util.HashMap;
import java.util.Map;

/**
 * LintCode 610. Two Sum - Difference equals to target
 *
 * Given an array of integers, find two numbers that their difference equals to a target value.
 * where index1 must be less than index2. Please note that your returned answers (both index1 and
 * index2) are NOT zero-based.
 */
interface LintCode610DifferenceEqualsToTarget {

  int[] twoSum7(int[] nums, int target);

  LintCode610DifferenceEqualsToTarget TWO_SUM = new LintCode610DifferenceEqualsToTarget() {

    @Override
    public int[] twoSum7(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
        return new int[]{0, 0};
      }

      int[] result = new int[2];
      Map<Integer, Integer> record = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        record.put(nums[i], i);
      }

      for (int i = 0; i < nums.length; i++) {
        if (record.containsKey((nums[i] + target))) {
          result[0] = record.get(nums[i] + target) + 1;
          result[1] = i + 1;
          break;
        } else if (record.containsKey(nums[i] - target)) {
          result[0] = record.get(nums[i] - target) + 1;
          result[1] = i + 1;
          break;
        }
      }

      if (result[0] > result[1]) {
        result[1] += result[0];
        result[0] = result[1] - result[0];
        result[1] -= result[0];
      }
      return result;
    }
  };
}
