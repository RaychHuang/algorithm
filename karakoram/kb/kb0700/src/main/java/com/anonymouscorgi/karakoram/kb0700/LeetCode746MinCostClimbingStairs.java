package com.anonymouscorgi.karakoram.kb0700;

import com.anonymouscorgi.karakoram.annotation.Easy;

/**
 * LeetCode 746. Min Cost Climbing Stairs
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once
 * you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 */
@Easy
interface LeetCode746MinCostClimbingStairs {

  int minCostClimbingStairs(int[] cost);

  LeetCode746MinCostClimbingStairs DP = new LeetCode746MinCostClimbingStairs() {

    @Override
    public int minCostClimbingStairs(int[] cost) {
      if (cost == null || cost.length == 0) {
        return 0;
      }
      int[] dp = new int[cost.length + 1];
      for (int i = 2; i < dp.length; i++) {
        dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
      }
      return dp[cost.length];
    }
  };
}
