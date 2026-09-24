// ═══════════════════════════════════════════════════════
// Problem: 3869. Smallest Index With Digit Sum Equal to Index
// Difficulty: Easy
// Topics: Array, Math
// Runtime: 1 ms (Beats 99.7%)
// Memory: 45.8 MB (Beats 11.4%)
// Submitted: Sep 24, 2026
// Link: https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/
// ═══════════════════════════════════════════════════════

class Solution {
    public int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int sum = 0;

            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }

            if (sum == i)
                return i;
        }

        return -1;
    }
}
