package com.anonymouscorgi.karakoram.kb0550;

import com.anonymouscorgi.karakoram.annotation.Medium;

/**
 * LintCode 587. Two Sum - Unique pairs
 *
 * Medium
 *
 * Given an array of integers, find how many unique pairs in the array such that their sum is equal
 * to a specific target number. Please return the number of pairs.
 *
 * Example
 *
 * Given nums =[1,1,2,45,46,46], target =47 return2 1 + 46 = 47; 2 + 45 = 47
 */
@Medium
interface LintCode587TwoSumUniquePairs {

  int twoSum6(int[] nums, int target);

  LintCode587TwoSumUniquePairs TWO_SUM = new LintCode587TwoSumUniquePairs() {

    @Override
    public int twoSum6(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int count = 0;
      int indexLt = 0;
      int indexRt = nums.length - 1;
      while (indexLt < indexRt) {
        int sum = nums[indexLt] + nums[indexRt];
        if (sum < target) {
          indexLt++;
        } else if (sum > target) {
          indexRt--;
        } else {
          count++;

          do {
            indexLt++;
          }
          while (indexLt < indexRt && nums[indexLt] == nums[indexLt - 1]);
          do {
            indexRt--;
          }
          while (indexLt < indexRt && nums[indexRt] == nums[indexRt + 1]);
        }
      }
      return count;
    }
  };
}
