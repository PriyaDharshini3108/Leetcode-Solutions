// ═══════════════════════════════════════════════════════
// Problem: 3812. Smallest Palindromic Rearrangement I
// Difficulty: Medium
// Topics: String, Sorting, Counting Sort
// Runtime: 31 ms (Beats 63.1%)
// Memory: 48.4 MB (Beats 23.7%)
// Submitted: Jul 28, 2026
// Link: https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
// ═══════════════════════════════════════════════════════

class Solution {

    public String smallestPalindrome(String s) {
        int len = s.length();
        int partition = len / 2;

        char[] chars = s.toCharArray();
        Arrays.sort(chars, 0, partition);

        for (int i = 0; i < partition; i++) {
            chars[len - 1 - i] = chars[i];
        }

        return new String(chars);
    }
}
