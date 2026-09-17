// ═══════════════════════════════════════════════════════
// Problem: 1573. Find Two Non-overlapping Sub-arrays Each With Target Sum
// Difficulty: Medium
// Topics: Array, Hash Table, Binary Search, Dynamic Programming, Sliding Window
// Runtime: 7 ms (Beats 84.3%)
// Memory: 90.7 MB (Beats 88.3%)
// Submitted: Sep 17, 2026
// Link: https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
// ═══════════════════════════════════════════════════════

class Solution {
    public int minSumOfLengths(int[] A, int k) {
        int n = A.length;
        int res = n + 1, sum = 0, i = 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);

        for (int j = 0; j < n; j++) {
            sum += A[j];

            while (sum > k)
                sum -= A[i++];

            dp[j + 1] = dp[j];

            if (sum == k) {
                res = Math.min(res, j - i + 1 + dp[i]);
                dp[j + 1] = Math.min(dp[j], j - i + 1);
            }
        }

        return res == n + 1 ? -1 : res;
    }
}
