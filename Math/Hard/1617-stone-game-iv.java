// ═══════════════════════════════════════════════════════
// Problem: 1617. Stone Game IV
// Difficulty: Hard
// Topics: Math, Dynamic Programming, Minimax, Game Theory, Nim Game, Sprague–Grundy Theorem, Zero-Sum Game
// Runtime: 2 ms (Beats 100.0%)
// Memory: 42.2 MB (Beats 90.3%)
// Submitted: Aug 10, 2026
// Link: https://leetcode.com/problems/stone-game-iv/
// ═══════════════════════════════════════════════════════

class Solution {
    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {

            // If i is a losing position,
            // every valid square move from i
            // creates a winning position.
            if (!dp[i]) {

                for (int j = 1; i + j * j <= n; j++) {
                    dp[i + j * j] = true;
                }

                // Once n becomes reachable from a losing position,
                // the first player can force a win.
                if (dp[n]) {
                    return true;
                }
            }
        }

        return false;
    }
}
