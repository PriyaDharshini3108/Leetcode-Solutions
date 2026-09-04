// ═══════════════════════════════════════════════════════
// Problem: 4284. Smallest Stable Index I
// Difficulty: Easy
// Topics: Array, Prefix Sum
// Runtime: 1 ms (Beats 99.8%)
// Memory: 46.1 MB (Beats 94.5%)
// Submitted: Sep 4, 2026
// Link: https://leetcode.com/problems/smallest-stable-index-i/
// ═══════════════════════════════════════════════════════

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffix = new int[n];
 
        int mn = Integer.MAX_VALUE;
        // Build suffix minimum
        for (int i = n - 1; i >= 0; i--) {
            mn = Math.min(mn, nums[i]);
            suffix[i] = mn;
        }
 
        int mx = 0;
        // Find first index with score <= k
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            int score = mx - suffix[i];
            if (score <= k)
                return i;
        }
 
        return -1;
    }
}
