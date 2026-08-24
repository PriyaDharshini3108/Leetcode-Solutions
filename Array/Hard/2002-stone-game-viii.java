// ═══════════════════════════════════════════════════════
// Problem: 2002. Stone Game VIII
// Difficulty: Hard
// Topics: Array, Math, Dynamic Programming, Minimax, Prefix Sum, Game Theory, Zero-Sum Game
// Runtime: 3 ms (Beats 100.0%)
// Memory: 83.1 MB (Beats 98.7%)
// Submitted: Aug 24, 2026
// Link: https://leetcode.com/problems/stone-game-viii/
// ═══════════════════════════════════════════════════════

class Solution {
    public int stoneGameVIII(int[] A) {
        int n = A.length;
        for (int i = 1; i < n; i++)
            A[i] += A[i - 1];

        int ans = A[n - 1];
        for (int i = n - 2; i > 0; i--)
            ans = Math.max(ans, A[i] - ans);

        return ans;
    }
}
