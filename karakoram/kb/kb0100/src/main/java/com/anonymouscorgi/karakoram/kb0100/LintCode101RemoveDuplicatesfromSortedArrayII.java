package com.anonymouscorgi.karakoram.kb0100;

/**
 * LintCode 101 · Remove Duplicates from Sorted Array II
 *
 * LeetCode 080. Remove Duplicates from Sorted Array II
 *
 * Easy
 *
 * Given a sorted array nums, logically remove the duplicates in place and return the length len,
 * such that each element appear at most twice in the first len elements of the original array nums.
 * If a number appears more than two times, then keep the number appears twice in array after
 * remove.
 */
interface LintCode101RemoveDuplicatesfromSortedArrayII {

  int removeDuplicates(int[] nums);

  // Accepted
  LintCode101RemoveDuplicatesfromSortedArrayII TWO_POINTERS = new LintCode101RemoveDuplicatesfromSortedArrayII() {

    @Override
    public int removeDuplicates(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int len = 2;
      for (int i = 2; i < nums.length; i++) {
        if (nums[i] == nums[len - 1] && nums[i] == nums[len - 2]) {
          continue;
        }
        nums[len++] = nums[i];
      }
      return len;
    }
  };
}
