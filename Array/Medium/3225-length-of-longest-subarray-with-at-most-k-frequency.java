// ═══════════════════════════════════════════════════════
// Problem: 3225. Length of Longest Subarray With at Most K Frequency
// Difficulty: Medium
// Topics: Array, Hash Table, Sliding Window
// Runtime: 66 ms (Beats 74.6%)
// Memory: 88.8 MB (Beats 64.2%)
// Submitted: Aug 12, 2026
// Link: https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/
// ═══════════════════════════════════════════════════════

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();

        int i = 0, j = 0;
        int res = 0;

        while (j < nums.length) {
            m.put(nums[j], m.getOrDefault(nums[j], 0) + 1);

            while (m.get(nums[j]) > k) {
                m.put(nums[i], m.get(nums[i]) - 1);
                i++;
            }

            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}
