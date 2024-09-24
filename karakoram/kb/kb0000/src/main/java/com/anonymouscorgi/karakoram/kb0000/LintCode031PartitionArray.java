package com.anonymouscorgi.karakoram.kb0000;

/**
 * LintCode 031 · Partition Array
 *
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in
 * "nums") such that:
 *
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 */
interface LintCode031PartitionArray {

  int partitionArray(int[] nums, int k);

  // Accepted
  LintCode031PartitionArray TWO_POINTERS = new LintCode031PartitionArray() {
    @Override
    public int partitionArray(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int left = 0, firstK = nums.length;

      while (left < firstK) {
        if (nums[left] >= k) {
          int temp = nums[--firstK];
          nums[firstK] = nums[left];
          nums[left] = temp;
        } else {
          left++;
        }
      }

      return firstK;
    }
  };

  LintCode031PartitionArray TWO_POINTERS_2 = new LintCode031PartitionArray() {
    @Override
    public int partitionArray(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int left = -1, cursor = 0;

      while (cursor < nums.length) {
        if (nums[cursor] < k) {
          int temp = nums[++left];
          nums[cursor] = nums[left];
          nums[left] = temp;
        }
        cursor++;
      }

      return left + 1;
    }
  };
}
