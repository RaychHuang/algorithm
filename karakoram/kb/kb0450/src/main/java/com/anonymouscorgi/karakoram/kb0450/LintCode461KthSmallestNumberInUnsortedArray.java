package com.anonymouscorgi.karakoram.kb0450;

import com.anonymouscorgi.karakoram.annotation.Medium;

/**
 * LintCode 461. Kth Smallest Numbers in Unsorted Array
 *
 * Find the kth smallest numbers in an unsorted integer array.
 */
@Medium
interface LintCode461KthSmallestNumberInUnsortedArray {

  int kthSmallest(int k, int[] nums);

  LintCode461KthSmallestNumberInUnsortedArray PARTITION = new LintCode461KthSmallestNumberInUnsortedArray() {

    @Override
    public int kthSmallest(int k, int[] nums) {
      if (nums == null || nums.length < k) {
        return -1;
      }
      return sort(k, nums, 0, nums.length - 1);
    }

    private static int sort(int k, int[] nums, int start, int end) {
      int pivot = nums[end];
      int pointer = start - 1;
      for (int i = start; i <= end; i++) {
        if (nums[i] <= pivot) {
          pointer++;
          int temp = nums[pointer];
          nums[pointer] = nums[i];
          nums[i] = temp;
        }
      }

      if (pointer < k - 1) {
        return sort(k, nums, pointer + 1, end);
      } else if (pointer > k - 1) {
        return sort(k, nums, start, pointer - 1);
      } else {
        return nums[k - 1];
      }
    }
  };
}
