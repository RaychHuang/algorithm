package jiuzhang.dp.backpack;

/**
 * Same as LeetCode 518. Coin Change 2
 * <p>
 * Description
 * Given an integer array nums with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example
 * Given nums = [1, 2, 4], target = 4
 * The possible combination ways are:
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [2, 2]
 * [4]
 * return 4
 */
public class BackPackVII {

    /**
     * The solution will return combination.
     * Because the n-1 situation in here is the result made by the first n-1 elements,
     * the previous n-1 results don't contain the nth element.
     * so the result is kind of combination rather than permutation.
     */
    //Count How many ways can get to target with repeated use. Permutation of coins DOES NOT matters.
    private interface Method {
        int backPackVII(int[] weights, int capacity);
    }

    private class Method1 implements Method {

        @Override
        public int backPackVII(int[] weights, int capacity) {
            if (weights == null || weights.length == 0) {
                return 0;
            }
            int[] dp = new int[capacity + 1];
            dp[0] = 1;
            for (int weight : weights) {
                for (int j = weight; j <= capacity; j++) {
                    dp[j] += dp[j - weight];
                }
            }
            return dp[capacity];
        }
    }
}
