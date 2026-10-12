// ═══════════════════════════════════════════════════════
// Problem: 3153. Apply Operations on Array to Maximize Sum of Squares
// Difficulty: Hard
// Topics: Array, Hash Table, Greedy, Bit Manipulation
// Runtime: 29 ms (Beats 100.0%)
// Memory: 80.2 MB (Beats 100.0%)
// Submitted: Oct 12, 2026
// Link: https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/
// ═══════════════════════════════════════════════════════

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007;
        int[] cnt = new int[30];  // coins in each bit column, never changes
        for (int x : nums)
            for (int b = 0; b < 30; b++) cnt[b] += x >> b & 1;
        long total = 0;
        for (int i = 0; i < k; i++) {  // build row i of the stacked picture
            long row = 0;
            for (int b = 0; b < 30; b++)
                if (cnt[b] > i) row |= 1L << b;  // a coin from every column with more than i coins
            total = (total + row * row) % MOD;
        }
        return (int) total;
    }
}
