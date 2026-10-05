// ═══════════════════════════════════════════════════════
// Problem: 886. Score of Parentheses
// Difficulty: Medium
// Topics: String, Stack, Bracket Sequences
// Runtime: 0 ms (Beats 100.0%)
// Memory: 42.6 MB (Beats 65.9%)
// Submitted: Oct 5, 2026
// Link: https://leetcode.com/problems/score-of-parentheses/
// ═══════════════════════════════════════════════════════

class Solution {
    public int scoreOfParentheses(String S) {
        return F(S, 0, S.length());
    }

    private int F(String S, int i, int j) {
        int ans = 0, bal = 0;

        // Split string into primitives
        for (int k = i; k < j; ++k) {
            bal += S.charAt(k) == '(' ? 1 : -1;
            if (bal == 0) {
                if (k - i == 1) {
                    ans++;
                } else {
                    ans += 2 * F(S, i + 1, k);
                }
                // Move start pointer for the next primitive
                i = k + 1; 
            }
        }

        return ans;
    }
}
