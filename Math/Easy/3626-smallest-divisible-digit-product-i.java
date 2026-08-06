// ═══════════════════════════════════════════════════════
// Problem: 3626. Smallest Divisible Digit Product I
// Difficulty: Easy
// Topics: Math, Enumeration
// Runtime: 1 ms (Beats 100.0%)
// Memory: 42.5 MB (Beats 66.5%)
// Submitted: Aug 6, 2026
// Link: https://leetcode.com/problems/smallest-divisible-digit-product-i/
// ═══════════════════════════════════════════════════════

class Solution {
    public int smallestNumber(int n, int t) {
        int q = n / 10, r = n % 10;

        int req = t / gcd(q + (10 - q) / 10, t);
        int nxt = ((r + req - 1) / req) * req;
        int x = nxt - (nxt - 10) * (nxt / 10);

        return q * 10 + x;
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
