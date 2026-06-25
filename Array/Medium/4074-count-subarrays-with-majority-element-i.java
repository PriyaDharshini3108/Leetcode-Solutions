// ═══════════════════════════════════════════════════════
// Problem: 4074. Count Subarrays With Majority Element I
// Difficulty: Medium
// Topics: Array, Hash Table, Divide and Conquer, Segment Tree, Merge Sort, Counting, Prefix Sum
// Runtime: 33 ms (Beats 77.8%)
// Memory: 46.9 MB (Beats 63.4%)
// Submitted: Jun 25, 2026
// Link: https://leetcode.com/problems/count-subarrays-with-majority-element-i/
// ═══════════════════════════════════════════════════════

class Solution {

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            for (int j = i; j < n; ++j) {
                cnt += (nums[j] == target ? 1 : -1);
                if (cnt > 0) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
