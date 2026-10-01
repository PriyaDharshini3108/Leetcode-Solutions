// ═══════════════════════════════════════════════════════
// Problem: 20. Valid Parentheses
// Difficulty: Easy
// Topics: String, Stack, Bracket Sequences
// Runtime: 1 ms (Beats 99.9%)
// Memory: 42.5 MB (Beats 99.7%)
// Submitted: Oct 1, 2026
// Link: https://leetcode.com/problems/valid-parentheses/
// ═══════════════════════════════════════════════════════

class Solution {
    public boolean isValid(String str) {
        if (str.length() % 2 == 1)
            return false;

        char[] S = str.toCharArray();
        int i = 0;

        for (char c : S)
            if ((c & 3) != 1)
                S[i++] = c;
            else if (i == 0 || ((c - S[--i] + 1) >> 1) != 1)
                return false;        

        return i == 0;
    }
}
