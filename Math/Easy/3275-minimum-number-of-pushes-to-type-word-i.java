// ═══════════════════════════════════════════════════════
// Problem: 3275. Minimum Number of Pushes to Type Word I
// Difficulty: Easy
// Topics: Math, String, Greedy
// Runtime: 0 ms (Beats 100.0%)
// Memory: 43 MB (Beats 89.0%)
// Submitted: Jul 30, 2026
// Link: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
// ═══════════════════════════════════════════════════════

class Solution {
    public int minimumPushes(String A) {
        int q = A.length() >> 3;
        int r = A.length() & 7;
        return ((q << 2) + r) * (q + 1);
    }
}
