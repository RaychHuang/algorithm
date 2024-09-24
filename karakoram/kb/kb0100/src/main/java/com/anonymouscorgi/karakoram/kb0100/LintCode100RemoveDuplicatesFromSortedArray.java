package com.anonymouscorgi.karakoram.kb0100;

/**
 * LintCode 100 · Remove Duplicates from Sorted Array
 *
 * LeetCode 026. Remove Duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in place such that each element appear only once and
 * return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Example
 *
 * Given input array A = [1,1,2],
 *
 * Your function should return length = 2, and A is now [1,2].
 */
interface LintCode100RemoveDuplicatesFromSortedArray {

  int removeDuplicates(int[] nums);

  // Accepted
  LintCode100RemoveDuplicatesFromSortedArray TWO_POINTERS = new LintCode100RemoveDuplicatesFromSortedArray() {

    @Override
    public int removeDuplicates(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int len = 1;
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] == nums[len - 1]) {
          continue;
        }
        nums[len++] = nums[i];
      }
      return len;
    }
  };
}
