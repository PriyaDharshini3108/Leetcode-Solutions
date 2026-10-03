// ═══════════════════════════════════════════════════════
// Problem: 32. Longest Valid Parentheses
// Difficulty: Hard
// Topics: String, Dynamic Programming, Stack, Bracket Sequences
// Runtime: 5 ms (Beats 75.3%)
// Memory: 46.6 MB (Beats 41.1%)
// Submitted: Oct 3, 2026
// Link: https://leetcode.com/problems/longest-valid-parentheses/
// ═══════════════════════════════════════════════════════

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        st.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty())
                    st.push(i);
                else
                    res = Math.max(res, i - st.peek());
            }
        }
        return res;
    }
}
