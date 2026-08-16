// ═══════════════════════════════════════════════════════
// Problem: 2156. Stone Game IX
// Difficulty: Medium
// Topics: Array, Math, Greedy, Minimax, Counting, Game Theory, Nim Game, Zero-Sum Game
// Runtime: 4 ms (Beats 75.7%)
// Memory: 118.1 MB (Beats 10.8%)
// Submitted: Aug 16, 2026
// Link: https://leetcode.com/problems/stone-game-ix/
// ═══════════════════════════════════════════════════════

class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] f = {0, 0, 0};

        for (int s : stones)
            f[s % 3]++;

        if ((f[0] & 1) == 0)
            return Math.min(f[1], f[2]) > 0;

        return Math.abs(f[1] - f[2]) > 2;
    }
}
