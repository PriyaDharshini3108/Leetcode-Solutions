// ═══════════════════════════════════════════════════════
// Problem: 1737. Maximum Nesting Depth of the Parentheses
// Difficulty: Easy
// Topics: String, Stack, Bracket Sequences
// Runtime: 0 ms (Beats 100.0%)
// Memory: 42.8 MB (Beats 51.8%)
// Submitted: Sep 28, 2026
// Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
// ═══════════════════════════════════════════════════════

class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                depth--;
                continue;
            }
            // Digits and operators
            if (c != '(') continue;
            depth++;
            // New max only possible after '('
            if (depth > r) r = depth;
        }
        return r;
    }
}
