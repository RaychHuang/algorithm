package com.anonymouscorgi.karakoram.kb0150;

import com.anonymouscorgi.karakoram.annotation.Accepted;
import com.anonymouscorgi.karakoram.annotation.Medium;

/**
 * LeetCode 162. Find Peak Element
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array
 * contains multiple peaks, return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to
 * be strictly greater than a neighbor that is outside the array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 *
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your function should
 * return the index number 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4] Output: 5 Explanation: Your function can return either index number
 * 1 where the peak element is 2, or index number 5 where the peak element is 6.
 * <p>
 *
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * <p>
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * nums[i] != nums[i + 1] for all valid i.
 */
@Medium
interface LeetCode162FindPeakElement {

  int findPeakElement(int[] nums);

  @Accepted
  LeetCode162FindPeakElement Method = new LeetCode162FindPeakElement() {

    @Override
    public int findPeakElement(int[] nums) {
      if (nums == null && nums.length == 00) {
        return -1;
      }
      int left = 0;
      int right = nums.length - 1;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < nums[mid + 1]) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

      return right;
    }
  };
}
