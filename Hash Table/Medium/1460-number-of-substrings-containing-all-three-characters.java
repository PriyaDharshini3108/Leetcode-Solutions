// ═══════════════════════════════════════════════════════
// Problem: 1460. Number of Substrings Containing All Three Characters
// Difficulty: Medium
// Topics: Hash Table, String, Sliding Window
// Runtime: 10 ms (Beats 95.6%)
// Memory: 46 MB (Beats 90.4%)
// Submitted: Jun 30, 2026
// Link: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
// ═══════════════════════════════════════════════════════

class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] p = {-1, -1, -1};

        for (int i = 0; i < s.length(); i++) {
            p[(s.charAt(i) & 31) - 1] = i;
            res += Math.min(p[0], Math.min(p[1], p[2])) + 1;
        }

        return res;
    }
}
