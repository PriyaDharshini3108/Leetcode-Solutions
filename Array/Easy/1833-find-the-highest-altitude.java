// ═══════════════════════════════════════════════════════
// Problem: 1833. Find the Highest Altitude
// Difficulty: Easy
// Topics: Array, Prefix Sum
// Runtime: 0 ms (Beats 100.0%)
// Memory: 43.3 MB (Beats 18.5%)
// Submitted: Jun 19, 2026
// Link: https://leetcode.com/problems/find-the-highest-altitude/
// ═══════════════════════════════════════════════════════

class Solution {
    public int largestAltitude(int[] gain) {
        int maxHeight = 0;
        int currHeight = 0;

        for (int g : gain) {
            currHeight += g;
            maxHeight = Math.max(maxHeight, currHeight);
        }

        return maxHeight;
    }
}
