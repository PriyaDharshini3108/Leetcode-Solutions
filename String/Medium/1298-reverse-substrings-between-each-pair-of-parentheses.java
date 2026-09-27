// ═══════════════════════════════════════════════════════
// Problem: 1298. Reverse Substrings Between Each Pair of Parentheses
// Difficulty: Medium
// Topics: String, Stack, Bracket Sequences
// Runtime: 1 ms (Beats 100.0%)
// Memory: 42.7 MB (Beats 94.7%)
// Submitted: Sep 27, 2026
// Link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
// ═══════════════════════════════════════════════════════

class Solution { 
    public String reverseParentheses(String s) { 
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') st.push(i);
            else if (s.charAt(i) == ')') {
                int j = st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder res = new StringBuilder();
        int i = 0, dir = 1;
        while (i >= 0 && i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                dir = -dir;
            } else {
                res.append(s.charAt(i));
            }
            i += dir;
        }
        return res.toString();
    } 
}
