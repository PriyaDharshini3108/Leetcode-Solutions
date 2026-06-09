// ═══════════════════════════════════════════════════════
// Problem: 4005. Maximum Total Subarray Value I
// Difficulty: Medium
// Topics: Array, Greedy
// Runtime: 1 ms (Beats 100.0%)
// Memory: 62.3 MB (Beats 38.1%)
// Submitted: Jun 9, 2026
// Link: https://leetcode.com/problems/maximum-total-subarray-value-i/
// ═══════════════════════════════════════════════════════

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        for (int x : nums) {
            maxi = Math.max(maxi, x);
            mini = Math.min(mini, x);
        }

        return 1L * k * (maxi - mini);
    }
}
