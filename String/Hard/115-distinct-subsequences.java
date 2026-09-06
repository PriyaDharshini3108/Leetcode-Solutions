// ═══════════════════════════════════════════════════════
// Problem: 115. Distinct Subsequences
// Difficulty: Hard
// Topics: String, Dynamic Programming
// Runtime: 14 ms (Beats 92.7%)
// Memory: 54.6 MB (Beats 20.8%)
// Submitted: Sep 6, 2026
// Link: https://leetcode.com/problems/distinct-subsequences/
// ═══════════════════════════════════════════════════════

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
