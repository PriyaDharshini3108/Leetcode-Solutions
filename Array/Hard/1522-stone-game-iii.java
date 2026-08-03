// ═══════════════════════════════════════════════════════
// Problem: 1522. Stone Game III
// Difficulty: Hard
// Topics: Array, Math, Dynamic Programming, Game Theory
// Runtime: 7 ms (Beats 88.4%)
// Memory: 85.6 MB (Beats 60.2%)
// Submitted: Aug 3, 2026
// Link: https://leetcode.com/problems/stone-game-iii/
// ═══════════════════════════════════════════════════════

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            int best = Integer.MIN_VALUE;
            int runningSum = 0;
            for (int k = 1; k <= 3; k++) {
                if (i + k > n) break;
                runningSum += stoneValue[i + k - 1];
                best = Math.max(best, runningSum - dp[i + k]);
            }
            dp[i] = best;
        }
        
        if (dp[0] > 0) return "Alice";
        else if (dp[0] < 0) return "Bob";
        else return "Tie";
    }
}
