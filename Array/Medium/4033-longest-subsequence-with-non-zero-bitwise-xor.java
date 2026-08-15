// ═══════════════════════════════════════════════════════
// Problem: 4033. Longest Subsequence With Non-Zero Bitwise XOR
// Difficulty: Medium
// Topics: Array, Bit Manipulation
// Runtime: 2 ms (Beats 68.4%)
// Memory: 133.4 MB (Beats 75.0%)
// Submitted: Aug 16, 2026
// Link: https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/
// ═══════════════════════════════════════════════════════

class Solution {
    public int longestSubsequence(int[] A) {
        int tot = 0, n = A.length;
        boolean nonZero = false;

        for (int x : A) {
            nonZero |= x > 0;
            tot ^= x;
        }

        if (!nonZero) return 0;
        return tot == 0 ? n - 1 : n;
    }
}
