// ═══════════════════════════════════════════════════════
// Problem: 4248. Count Commas in Range II
// Difficulty: Medium
// Topics: Math
// Runtime: 1 ms (Beats 99.4%)
// Memory: 42.5 MB (Beats 71.2%)
// Submitted: Sep 9, 2026
// Link: https://leetcode.com/problems/count-commas-in-range-ii/
// ═══════════════════════════════════════════════════════

class Solution {
    public long countCommas(long n) {
        long count = 0;

        for (long p = 1000; p <= n; p *= 1000)
            count += n - p + 1;

        return count;
    }
}
