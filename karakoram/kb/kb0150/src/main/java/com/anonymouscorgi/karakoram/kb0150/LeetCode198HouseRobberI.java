package com.anonymouscorgi.karakoram.kb0150;

import com.anonymouscorgi.karakoram.annotation.Easy;

/**
 * LeetCode 198. House Robber Easy
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine
 * the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1: Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and then rob house 3
 * (money = 3). Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2: Input: [2,7,9,3,1] Output: 12 Explanation: Rob house 1 (money = 2), rob house 3 (money
 * = 9) and rob house 5 (money = 1). Total amount you can rob = 2 + 9 + 1 = 12.
 */
@Easy
interface LeetCode198HouseRobberI {

  int rob(int[] nums);

  LeetCode198HouseRobberI DP_Method = new LeetCode198HouseRobberI() {

    @Override
    public int rob(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int len = nums.length;
      int[] dp = new int[len + 1];
      dp[1] = nums[0];
      for (int i = 2; i <= len; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
      }
      return dp[len];
    }
  };

  LeetCode198HouseRobberI DP_Memory_Improved_Method = new LeetCode198HouseRobberI() {

    @Override
    public int rob(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int minus1 = 0;
      int minus2 = 0;
      for (int num : nums) {
        int temp = minus1;
        minus1 = Math.max(minus1, minus2 + num);
        minus2 = temp;
      }
      return minus1;
    }
  };
}
