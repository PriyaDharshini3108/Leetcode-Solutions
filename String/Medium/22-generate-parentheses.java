// ═══════════════════════════════════════════════════════
// Problem: 22. Generate Parentheses
// Difficulty: Medium
// Topics: String, Dynamic Programming, Backtracking, Bracket Sequences
// Runtime: 3 ms (Beats 14.5%)
// Memory: 44.8 MB (Beats 32.3%)
// Submitted: Oct 2, 2026
// Link: https://leetcode.com/problems/generate-parentheses/
// ═══════════════════════════════════════════════════════

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n-- == 1) return List.of("()");
        dfs(n, n, "(");

        return res;
    }

    private void dfs(int O, int C, String s) {
        if (O == 0 && C == 0) {
            res.add(s + ")");
            return;
        }

        if (O > 0)
            dfs(O - 1, C, s + "(");

        if (C >= O)
            dfs(O, C - 1, s + ")");
    }
}
