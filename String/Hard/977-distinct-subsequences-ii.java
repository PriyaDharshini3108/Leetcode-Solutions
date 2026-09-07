// ═══════════════════════════════════════════════════════
// Problem: 977. Distinct Subsequences II
// Difficulty: Hard
// Topics: String, Dynamic Programming
// Runtime: 4 ms (Beats 70.6%)
// Memory: 42.9 MB (Beats 98.2%)
// Submitted: Sep 7, 2026
// Link: https://leetcode.com/problems/distinct-subsequences-ii/
// ═══════════════════════════════════════════════════════

class Solution {
    int MOD = 1000000007;

    public int distinctSubseqII(String s) {
        int tot = 0;
        int[] dp = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 97;
            int add = (tot - dp[c] + MOD) % MOD;

            dp[c] = 1 + tot;
            tot = (dp[c] + add) % MOD;
        }

        return tot;
    }
}
