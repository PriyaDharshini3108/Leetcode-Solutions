// ═══════════════════════════════════════════════════════
// Problem: 3811. Reverse Degree of a String
// Difficulty: Easy
// Topics: String, Simulation
// Runtime: 1 ms (Beats 100.0%)
// Memory: 43.9 MB (Beats 67.4%)
// Submitted: Sep 20, 2026
// Link: https://leetcode.com/problems/reverse-degree-of-a-string/
// ═══════════════════════════════════════════════════════

class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int reverseValue = 26 - (c - 'a');
            int position = i + 1;

            sum += reverseValue * position;
        }
        return sum;
    }
}
