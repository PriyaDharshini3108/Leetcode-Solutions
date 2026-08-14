// ═══════════════════════════════════════════════════════
// Problem: 3349. Maximum Length Substring With Two Occurrences
// Difficulty: Easy
// Topics: Hash Table, String, Sliding Window
// Runtime: 3 ms (Beats 43.0%)
// Memory: 43.6 MB (Beats 70.7%)
// Submitted: Aug 14, 2026
// Link: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/
// ═══════════════════════════════════════════════════════

class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            count.put(c, count.getOrDefault(c, 0) + 1);
            while (count.get(c) > 2) {
                char left = s.charAt(i);
                count.put(left, count.get(left) - 1);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
