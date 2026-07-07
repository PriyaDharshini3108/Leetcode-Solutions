// ═══════════════════════════════════════════════════════
// Problem: 4135. Concatenate Non-Zero Digits and Multiply by Sum I
// Difficulty: Easy
// Topics: Math
// Runtime: 1 ms (Beats 99.9%)
// Memory: 42.6 MB (Beats 52.2%)
// Submitted: Jul 7, 2026
// Link: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/
// ═══════════════════════════════════════════════════════

class Solution {
    public long sumAndMultiply(int n) {
        long x = 0, s = 0;
        for (char c : String.valueOf(n).toCharArray())
            if (c != '0') {
                x = x * 10 + c - '0';
                s += c - '0';
            }
        return x * s;
    }
}
