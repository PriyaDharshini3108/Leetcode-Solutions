// ═══════════════════════════════════════════════════════
// Problem: 2099. Number of Strings That Appear as Substrings in Word
// Difficulty: Easy
// Topics: Array, String
// Runtime: 0 ms (Beats 100.0%)
// Memory: 43.4 MB (Beats 56.0%)
// Submitted: Jun 29, 2026
// Link: https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
// ═══════════════════════════════════════════════════════

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String s : patterns)
            if (word.indexOf(s) != -1) count++; // -1 when not found
        return count;
    }
}
