// ═══════════════════════════════════════════════════════
// Problem: 3831. Find X Value of Array I
// Difficulty: Medium
// Topics: Array, Math, Dynamic Programming
// Runtime: 11 ms (Beats 98.1%)
// Memory: 98.4 MB (Beats 15.4%)
// Submitted: Sep 21, 2026
// Link: https://leetcode.com/problems/find-x-value-of-array-i/
// ═══════════════════════════════════════════════════════

class Solution {
    public long[] resultArray(int[] A, int k) {
        long[] res = new long[k];
        int[] freq = new int[k];

        for (int n : A) {
            n %= k;
            int[] cur = new int[k];
            cur[n] = 1;

            for (int x = 0; x < k; x++)
                cur[x * n % k] += freq[x];

            freq = cur;
            for (int x = 0; x < k; x++)
                res[x] += freq[x];
        }

        return res;
    }
}
