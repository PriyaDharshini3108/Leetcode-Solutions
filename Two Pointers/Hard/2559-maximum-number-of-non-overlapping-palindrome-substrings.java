// ═══════════════════════════════════════════════════════
// Problem: 2559. Maximum Number of Non-overlapping Palindrome Substrings
// Difficulty: Hard
// Topics: Two Pointers, String, Dynamic Programming, Greedy
// Runtime: 1 ms (Beats 100.0%)
// Memory: 42.9 MB (Beats 79.4%)
// Submitted: Sep 15, 2026
// Link: https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
// ═══════════════════════════════════════════════════════

class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n;

        int res = 0;

        for (int i = 0; i <= n - k; i++) {
            if (check(s, i, i + k - 1)) {
                res++;
                i += k - 1;
            } else if (i < n - k && check(s, i, i + k)) {
                res++;
                i += k;
            }
        }

        return res;
    }

    boolean check(String s, int l, int r) {
        for (; l < r; l++, r--)
            if (s.charAt(l) != s.charAt(r))
                return false;
        return true;
    }
}
