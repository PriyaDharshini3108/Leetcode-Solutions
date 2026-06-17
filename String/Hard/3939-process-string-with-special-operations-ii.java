// ═══════════════════════════════════════════════════════
// Problem: 3939. Process String with Special Operations II
// Difficulty: Hard
// Topics: String, Simulation
// Runtime: 28 ms (Beats 88.5%)
// Memory: 47.8 MB (Beats 65.4%)
// Submitted: Jun 17, 2026
// Link: https://leetcode.com/problems/process-string-with-special-operations-ii/
// ═══════════════════════════════════════════════════════

class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        // Step 1
        for (char c : s.toCharArray()) {
            if (c == '*') len = Math.max(0, len - 1);
            else if (c == '#') len *= 2;
            else if (c != '%') len++;
        }

        if (k >= len) return '.';

        // Step 2
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '*') len++;

            else if (c == '#') {
                long half = len / 2;
                if (k >= half) k -= half;
                len = half;
            }

            else if (c == '%') {
                k = len - 1 - k;
            }

            else {
                if (k == len - 1) return c;
                len--;
            }
        }

        return '.';
    }
}
