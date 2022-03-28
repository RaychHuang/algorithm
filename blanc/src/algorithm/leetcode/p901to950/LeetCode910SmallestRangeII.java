package algorithm.leetcode.p901to950;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode910SmallestRangeII {
  
  interface SmallestRangeII {
    int smallestRangeII(int[] A, int K);
  }
  
  public static class My_method implements SmallestRangeII {
    
    public int smallestRangeII(int[] A, int K) {
      List<int[]> range = new ArrayList<>();
      for (int i = 0; i < A.length; i++) {
        range.add(new int[]{A[i] + K, i});
        range.add(new int[]{A[i] - K, i});
      }
      Collections.sort(range, (a, b) -> (a[0] - b[0]));
      int[] added = new int[A.length];
      int head = 0;
      int count = 0;
      int min = Integer.MAX_VALUE;
      for (int i = 0, iLen = range.size(); i < iLen; i++) {
        if (added[range.get(i)[1]]++ == 0) {
          count++;
        }
        
        while (count == A.length) {
          min = Math.min(min, range.get(i)[0] - range.get(head)[0]);
          
          if (added[range.get(head++)[1]]-- == 1) {
            count--;
          }
        }
      }
      return min;
    }
    
  }
  
  public static class Prime_method implements SmallestRangeII {
    
    public int smallestRangeII(int[] A, int K) {
      Arrays.sort(A);
      int n = A.length;
      int res = A[n - 1] - A[0];
      for (int i = 0; i < n - 1; i++) {
        int max = Math.max(A[i] + K, A[n - 1] - K);
        int min = Math.min(A[i + 1] - K, A[0] + K);
        res = Math.min(res, max - min);
      }
      return res;
    }
    
  }

}
