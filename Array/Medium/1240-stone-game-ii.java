// ═══════════════════════════════════════════════════════
// Problem: 1240. Stone Game II
// Difficulty: Medium
// Topics: Array, Math, Dynamic Programming, Minimax, Prefix Sum, Game Theory, Zero-Sum Game
// Runtime: 17 ms (Beats 22.4%)
// Memory: 46.8 MB (Beats 22.3%)
// Submitted: Aug 9, 2026
// Link: https://leetcode.com/problems/stone-game-ii/
// ═══════════════════════════════════════════════════════

class Solution {
    private int dfs(int i, int m, int[] piles, Map<Integer, Integer> memo) {
        int n = piles.length;

        if (i + m * 2 >= n)
            return piles[i];

        int key = (i << 8) | m;

        if (memo.containsKey(key))
            return memo.get(key);

        int res = Integer.MAX_VALUE;

        for (int k = 1; k <= m * 2; k++)
            res = Math.min(res, dfs(i + k, Math.max(m, k), piles, memo));

        int val = piles[i] - res;
        
        memo.put(key, val);

        return val;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        for (int i = n - 2; i >= 0; i--)
            piles[i] += piles[i + 1];

        Map<Integer, Integer> memo = new HashMap<>();

        return dfs(0, 1, piles, memo);
    }
}
