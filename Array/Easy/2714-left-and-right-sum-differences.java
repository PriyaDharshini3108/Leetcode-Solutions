// ═══════════════════════════════════════════════════════
// Problem: 2714. Left and Right Sum Differences
// Difficulty: Easy
// Topics: Array, Prefix Sum
// Runtime: 2 ms (Beats 98.8%)
// Memory: 46 MB (Beats 98.7%)
// Submitted: Jun 6, 2026
// Link: https://leetcode.com/problems/left-and-right-sum-differences/
// ═══════════════════════════════════════════════════════

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int prefix = 0;
        int suffix = 0;
        for (int i : nums) {
            suffix += i;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            res[i] = Math.abs(prefix - suffix);
            suffix -= nums[i];
        }
        return res;
    }
}
