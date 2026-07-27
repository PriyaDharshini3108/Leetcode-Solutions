// ═══════════════════════════════════════════════════════
// Problem: 1574. Maximum Product of Two Elements in an Array
// Difficulty: Easy
// Topics: Array, Sorting, Heap (Priority Queue)
// Runtime: 5 ms (Beats 42.3%)
// Memory: 44 MB (Beats 98.7%)
// Submitted: Jul 27, 2026
// Link: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
// ═══════════════════════════════════════════════════════

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                max = Math.max(
                    (nums[i] - 1) * (nums[j] - 1),
                    max
                );
            }
        }

        return max;
    }
}
