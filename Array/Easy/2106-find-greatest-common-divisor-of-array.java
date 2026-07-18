// ═══════════════════════════════════════════════════════
// Problem: 2106. Find Greatest Common Divisor of Array
// Difficulty: Easy
// Topics: Array, Math, Number Theory
// Runtime: 0 ms (Beats 100.0%)
// Memory: 44.8 MB (Beats 94.1%)
// Submitted: Jul 18, 2026
// Link: https://leetcode.com/problems/find-greatest-common-divisor-of-array/
// ═══════════════════════════════════════════════════════

class Solution {
    public int findGCD(int[] nums) {
        int mn = 1001, mx = 0;

        for (int num : nums) {
            if (num < mn)
                mn = num;
            if (num > mx)
                mx = num;
        }

        return gcd(mn, mx);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}
