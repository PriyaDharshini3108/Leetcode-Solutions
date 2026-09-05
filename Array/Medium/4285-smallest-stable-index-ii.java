// ═══════════════════════════════════════════════════════
// Problem: 4285. Smallest Stable Index II
// Difficulty: Medium
// Topics: Array, Prefix Sum
// Runtime: 2 ms (Beats 100.0%)
// Memory: 124.8 MB (Beats 98.5%)
// Submitted: Sep 5, 2026
// Link: https://leetcode.com/problems/smallest-stable-index-ii/
// ═══════════════════════════════════════════════════════

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int maxSoFar = -1;
        int cand = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);

            if (i == cand) max = maxSoFar;

            if (nums[i] < max - k)
                cand = i + 1;
        }

        return cand < nums.length ? cand : -1;
    }
}
