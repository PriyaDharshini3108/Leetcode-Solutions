// ═══════════════════════════════════════════════════════
// Problem: 1159. Smallest Subsequence of Distinct Characters
// Difficulty: Medium
// Topics: String, Stack, Greedy, Monotonic Stack
// Runtime: 3 ms (Beats 71.4%)
// Memory: 42.9 MB (Beats 47.0%)
// Submitted: Jul 19, 2026
// Link: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
// ═══════════════════════════════════════════════════════

class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[27];
        boolean[] seen = new boolean[27];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) & 31]++;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int x = c & 31;
            freq[x]--;

            if (seen[x])
                continue;

            while (!stack.isEmpty()) {
                if (stack.peek() <= c)
                    break;

                if (freq[stack.peek() & 31] == 0)
                    break;

                seen[stack.peek() & 31] = false;
                stack.pop();
            }

            stack.push(c);
            seen[x] = true;
        }

        StringBuilder res = new StringBuilder();

        for (char c : stack)
            res.append(c);

        return res.toString();
    }
}
