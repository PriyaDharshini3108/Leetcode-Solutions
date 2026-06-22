// ═══════════════════════════════════════════════════════
// Problem: 1297. Maximum Number of Balloons
// Difficulty: Easy
// Topics: Hash Table, String, Counting
// Runtime: 1 ms (Beats 100.0%)
// Memory: 43.3 MB (Beats 71.4%)
// Submitted: Jun 22, 2026
// Link: https://leetcode.com/problems/maximum-number-of-balloons/
// ═══════════════════════════════════════════════════════


class Solution {
    public int maxNumberOfBalloons(String text) {
        int b=0;
        int a=0;
        int l=0;
        int o=0;
        int n=0;

        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
            }
        }


        return Math.min(b,Math.min(a,Math.min(n,Math.min(l/2,o/2))));
    }
}
