// ═══════════════════════════════════════════════════════
// Problem: 1725. Number of Sets of K Non-Overlapping Line Segments
// Difficulty: Medium
// Topics: Math, Dynamic Programming, Combinatorics, Prefix Sum
// Runtime: 0 ms (Beats 100.0%)
// Memory: 41.9 MB (Beats 96.1%)
// Submitted: Sep 16, 2026
// Link: https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/
// ═══════════════════════════════════════════════════════

class Solution {
    private static final long MOD = 1_000_000_007L;

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1L) != 0) {
                result = result * base % MOD;
            }

            base = base * base % MOD;

            exp >>= 1;
        }

        return result;
    }

    public int numberOfSets(int n, int k) {
        long N = n + k - 1L;
        long R = 2L * k;

        R = Math.min(R, N - R);

        long numerator = 1;
        long denominator = 1;

        for (long i = 1; i <= R; i++) {
            numerator = numerator * (N - R + i) % MOD;

            denominator = denominator * i % MOD;
        }

        long inverseDenominator = modPow(denominator, MOD - 2);

        return (int) (numerator * inverseDenominator % MOD);
    }
}
