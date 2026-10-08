// ═══════════════════════════════════════════════════════
// Problem: 1078. Remove Outermost Parentheses
// Difficulty: Easy
// Topics: String, Stack, Bracket Sequences
// Runtime: 4 ms (Beats 58.5%)
// Memory: 43.5 MB (Beats 71.5%)
// Submitted: Oct 8, 2026
// Link: https://leetcode.com/problems/remove-outermost-parentheses/
// ═══════════════════════════════════════════════════════

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int lvl = 0;

        for (int i = 0; i < s.length(); i++)
            if ((s.charAt(i) == '(' ? lvl++ : --lvl) > 0)
                sb.append(s.charAt(i));

        return sb.toString();
    }
}
