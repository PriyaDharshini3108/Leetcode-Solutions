// ═══════════════════════════════════════════════════════
// Problem: 1776. Minimum Operations to Reduce X to Zero
// Difficulty: Medium
// Topics: Array, Hash Table, Binary Search, Sliding Window, Prefix Sum
// Runtime: 4 ms (Beats 98.1%)
// Memory: 102.2 MB (Beats 44.6%)
// Submitted: Sep 23, 2026
// Link: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
// ═══════════════════════════════════════════════════════

class Solution {
    public int minOperations(int[] A, int x) {
        int k = -x, n = A.length;
        for (int a : A) k += a;
        if (k < 0) return -1;
        if (k == 0) return n;

        int best = -1, i = 0, s = 0;
        for (int j = 0; j < n; j++) {
            s += A[j];
            while (s > k)
                s -= A[i++];

            if (s == k)
                best = Math.max(best, j - i + 1);
        }

        return best < 0 ? -1 : n - best;
    }
}
