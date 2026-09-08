// ═══════════════════════════════════════════════════════
// Problem: 4245. Count Commas in Range
// Difficulty: Easy
// Topics: Math
// Runtime: 8 ms (Beats 8.5%)
// Memory: 42.7 MB (Beats 39.9%)
// Submitted: Sep 8, 2026
// Link: https://leetcode.com/problems/count-commas-in-range/
// ═══════════════════════════════════════════════════════

class Solution {
    public int countCommas(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (i >= 1000) {
                count++;
            }
        }

        return count;
    }
}
