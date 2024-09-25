package com.anonymouscorgi.karakoram.kb0000;

import com.anonymouscorgi.karakoram.annotation.Accepted;
import com.anonymouscorgi.karakoram.annotation.Easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 001. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * You can return the answer in any order.
 */
@Easy
interface LeetCode001TwoSum {

  int[] twoSum(int[] nums, int target);

  @Accepted
  LeetCode001TwoSum SET = new LeetCode001TwoSum() {
    @Override
    public int[] twoSum(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
        return new int[0];
      }

      Map<Integer, Integer> numMap = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int numTarget = target - nums[i];
        if (numMap.containsKey(numTarget)) {
          return new int[]{numMap.get(numTarget), i};
        }
        numMap.put(nums[i], i);
      }

      return new int[0];
    }
  };

  LeetCode001TwoSum TWO_POINTERS = new LeetCode001TwoSum() {

    @Override
    public int[] twoSum(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
        return new int[]{};
      }

      int indexLt = 0;
      int indexRt = nums.length - 1;
      while (indexLt < indexRt) {
        int sum = nums[indexLt] + nums[indexRt];
        if (sum < target) {
          indexLt++;
        } else if (sum > target) {
          indexRt--;
        } else {
          return new int[]{indexLt, indexRt};
        }
      }

      return new int[]{};
    }
  };
}
