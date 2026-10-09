// ═══════════════════════════════════════════════════════
// Problem: 1648. Minimum Insertions to Balance a Parentheses String
// Difficulty: Medium
// Topics: String, Stack, Greedy, Bracket Sequences
// Runtime: 11 ms (Beats 68.6%)
// Memory: 47.4 MB (Beats 74.9%)
// Submitted: Oct 9, 2026
// Link: https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
// ═══════════════════════════════════════════════════════

class Solution {
    public int minInsertions(String s) {
        int open = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else {
                // Step 1: make a "))"
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') i++;
                else ans++;

                // Step 2: find its '('
                if (open > 0) open--;
                else ans++;
            }
        }

        return ans + open * 2;
    }
}
