// ═══════════════════════════════════════════════════════
// Problem: 3918. Check Divisibility by Digit Sum and Product
// Difficulty: Easy
// Topics: Math
// Runtime: 0 ms (Beats 100.0%)
// Memory: 42.6 MB (Beats 24.7%)
// Submitted: Aug 22, 2026
// Link: https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/
// ═══════════════════════════════════════════════════════

class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int digitSum = 0;
        int digitProduct = 1;

        while (n > 0) {
            int digit = n % 10;
            digitSum += digit;
            digitProduct *= digit;
            n /= 10;
        }

        int divisor = digitSum + digitProduct;
        return original % divisor == 0;
    }
}
