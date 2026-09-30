// ═══════════════════════════════════════════════════════
// Problem: 1208. Maximum Nesting Depth of Two Valid Parentheses Strings
// Difficulty: Medium
// Topics: String, Stack, Bracket Sequences
// Runtime: 2 ms (Beats 57.9%)
// Memory: 45.2 MB (Beats 84.4%)
// Submitted: Sep 30, 2026
// Link: https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
// ═══════════════════════════════════════════════════════

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] answer = new int[seq.length()];
        int currentGroup = 1;

        for (int index = 0; index < seq.length(); index++) {
            char bracket = seq.charAt(index);

            if (bracket == '(') {
                answer[index] = 1 - currentGroup;
            } else {
                answer[index] = currentGroup;
            }

            currentGroup ^= 1;
        }

        return answer;
    }
}
