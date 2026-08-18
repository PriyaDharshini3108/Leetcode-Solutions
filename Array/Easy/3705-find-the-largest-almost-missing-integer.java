// ═══════════════════════════════════════════════════════
// Problem: 3705. Find the Largest Almost Missing Integer
// Difficulty: Easy
// Topics: Array, Hash Table
// Runtime: 1 ms (Beats 99.3%)
// Memory: 44.4 MB (Beats 94.4%)
// Submitted: Aug 18, 2026
// Link: https://leetcode.com/problems/find-the-largest-almost-missing-integer/
// ═══════════════════════════════════════════════════════

class Solution {
    public int largestInteger(int[] A, int k) {
        int[] f = new int[51];
        for (int x : A)
            f[x]++;

        int res = -1, n = A.length;
        for (int i = 0; i < n; i++) 
            if (k == n || (f[A[i]] == 1 && (k == 1 || i == 0 || i == n - 1)))
                res = Math.max(res, A[i]);

        return res;
    }
}
