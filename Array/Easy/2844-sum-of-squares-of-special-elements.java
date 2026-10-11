// ═══════════════════════════════════════════════════════
// Problem: 2844. Sum of Squares of Special Elements 
// Difficulty: Easy
// Topics: Array, Enumeration
// Runtime: 1 ms (Beats 100.0%)
// Memory: 46.2 MB (Beats 70.2%)
// Submitted: Oct 11, 2026
// Link: https://leetcode.com/problems/sum-of-squares-of-special-elements/
// ═══════════════════════════════════════════════════════

class Solution {
    public int sumOfSquares(int[] nums) {
        int index = 0;
        int n = nums.length;

        // i = index, counting from 0  ->  position = i + 1
        for (int i = 0; i < nums.length; i++) {
            if (n % (i + 1) == 0) {
                index += nums[i] * nums[i];
            }
        }

        return index;
    }
}
