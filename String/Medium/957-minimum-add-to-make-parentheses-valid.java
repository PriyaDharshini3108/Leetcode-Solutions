// ═══════════════════════════════════════════════════════
// Problem: 957. Minimum Add to Make Parentheses Valid
// Difficulty: Medium
// Topics: String, Stack, Greedy, Bracket Sequences
// Runtime: 0 ms (Beats 100.0%)
// Memory: 43 MB (Beats 39.7%)
// Submitted: Oct 6, 2026
// Link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
// ═══════════════════════════════════════════════════════

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, add = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    add++;
                }
            }
        }
        return add + open;
    }
}
