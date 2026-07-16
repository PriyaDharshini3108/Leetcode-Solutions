// ═══════════════════════════════════════════════════════
// Problem: 4242. Sum of GCD of Formed Pairs
// Difficulty: Medium
// Topics: Array, Math, Two Pointers, Sorting, Simulation, Number Theory
// Runtime: 59 ms (Beats 37.5%)
// Memory: 122.5 MB (Beats 37.0%)
// Submitted: Jul 16, 2026
// Link: https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/
// ═══════════════════════════════════════════════════════

class Solution {
    private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    public long gcdSum(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            A[i] = gcd(A[i], max);
        }

        Arrays.sort(A);

        long res = 0;        
        for (int i = 0, j = A.length - 1; i < j; i++, j--)
            res += gcd(A[i], A[j]);

        return res;
    }
}
