// ═══════════════════════════════════════════════════════
// Problem: 628. Maximum Product of Three Numbers
// Difficulty: Easy
// Topics: Array, Math, Sorting
// Runtime: 3 ms (Beats 86.3%)
// Memory: 47.3 MB (Beats 85.9%)
// Submitted: Jul 26, 2026
// Link: https://leetcode.com/problems/maximum-product-of-three-numbers/
// ═══════════════════════════════════════════════════════

class Solution {
    public int maximumProduct(int[] A) {
        int n = A.length;

        for (int i = 0; i < 2; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++)
                if (A[j] < A[k]) k = j;
            swap(A, i, k);
        }

        for (int i = n - 1; i >= Math.max(0, n - 3); i--) {
            int k = i;
            for (int j = 0; j < i; j++)
                if (A[j] > A[k]) k = j;
            swap(A, i, k);
        }

        return Math.max(
            A[n - 1] * A[n - 2] * A[n - 3],
            A[n - 1] * A[0] * A[1]
        );
    }

    private void swap(int[] A, int i, int j) {
        if (i != j) {
            A[i] ^= A[j]; A[j] ^= A[i]; A[i] ^= A[j];
        }
    }
}
