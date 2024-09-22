package com.anonymouscorgi.karakoram.kb0050;

/**
 * LeetCode 053. Maximum Subarray
 * <p>
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: The subarray [4,-1,2,1] has the
 * largest sum 6.
 *
 * Example 2:
 *
 * Input: nums = [1] Output: 1 Explanation: The subarray [1] has the largest sum 1.
 *
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8] Output: 23 Explanation: The subarray [5,4,-1,7,8] has the largest sum
 * 23.
 */
interface LeetCode053MaximumSubarray {

  int maxSubArray(int[] nums);

  LeetCode053MaximumSubarray Greedy = new LeetCode053MaximumSubarray() {

    @Override
    public int maxSubArray(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int sum = 0;
      int max = Integer.MIN_VALUE;
      for (int num : nums) {
        sum += num;
        max = Math.max(max, sum);
        sum = Math.max(sum, 0);
      }
      return max;
    }
  };

  LeetCode053MaximumSubarray Greedy2 = new LeetCode053MaximumSubarray() {

    @Override
    public int maxSubArray(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int sum = 0;
      int min = 0;
      int max = Integer.MIN_VALUE;
      for (int num : nums) {
        sum += num;
        max = Math.max(max, sum - min);
        min = Math.min(min, sum);
      }
      return max;
    }
  };
}
