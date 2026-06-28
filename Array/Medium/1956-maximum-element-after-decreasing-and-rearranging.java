// ═══════════════════════════════════════════════════════
// Problem: 1956. Maximum Element After Decreasing and Rearranging
// Difficulty: Medium
// Topics: Array, Greedy, Sorting
// Runtime: 9 ms (Beats 67.5%)
// Memory: 77.3 MB (Beats 92.1%)
// Submitted: Jun 28, 2026
// Link: https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
// ═══════════════════════════════════════════════════════

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] A) {
        Arrays.sort(A);
        int n = A.length;

        A[0] = 1;
        for (int i = 1; i < n; i++)
            A[i] = Math.min(A[i], A[i - 1] + 1);
        
        return A[n - 1];
    }
}
