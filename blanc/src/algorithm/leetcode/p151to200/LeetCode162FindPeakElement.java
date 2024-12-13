package algorithm.leetcode.p151to200;

public class LeetCode162FindPeakElement {

  public int findPeakElement(int[] nums) {
    //start is the index where nums[start - 1] < nums[start]
    int start = 0;
    //end is the index where nums[end] > nums[end + 1]
    int end = nums.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < nums[mid + 1]) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return end;
  }
}
