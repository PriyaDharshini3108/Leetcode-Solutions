// ═══════════════════════════════════════════════════════
// Problem: 678. Valid Parenthesis String
// Difficulty: Medium
// Topics: String, Dynamic Programming, Stack, Greedy, Bracket Sequences
// Runtime: 0 ms (Beats 100.0%)
// Memory: 42.9 MB (Beats 34.1%)
// Submitted: Oct 4, 2026
// Link: https://leetcode.com/problems/valid-parenthesis-string/
// ═══════════════════════════════════════════════════════

class Solution {
    public boolean checkValidString(String s) {
        int l = 0, h = 0;

        for (int i = 0; i < s.length(); i++) {
            l += s.charAt(i) == '(' ? 1 : -1;
            h += s.charAt(i) == ')' ? -1 : 1;

            if (h < 0) return false;

            l = Math.max(l, 0);
        }

        return l == 0;
    }
}
