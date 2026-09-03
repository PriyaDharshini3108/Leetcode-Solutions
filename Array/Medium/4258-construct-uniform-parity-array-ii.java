// ═══════════════════════════════════════════════════════
// Problem: 4258. Construct Uniform Parity Array II
// Difficulty: Medium
// Topics: Array, Math
// Runtime: 2 ms (Beats 100.0%)
// Memory: 121.7 MB (Beats 44.2%)
// Submitted: Sep 3, 2026
// Link: https://leetcode.com/problems/construct-uniform-parity-array-ii/
// ═══════════════════════════════════════════════════════

class Solution {
    public boolean uniformArray(int[] A) {
        int min = A[0], odd = 0;

        for (int x : A) {
            min = Math.min(min, x);
            odd |= x & 1;
        }

        return (min & 1) == odd;
    }
}
