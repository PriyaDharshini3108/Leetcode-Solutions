// ═══════════════════════════════════════════════════════
// Problem: 3805. Maximize Active Section with Trade I
// Difficulty: Medium
// Topics: String, Enumeration
// Runtime: 169 ms (Beats 14.1%)
// Memory: 51.1 MB (Beats 12.7%)
// Submitted: Jul 21, 2026
// Link: https://leetcode.com/problems/maximize-active-section-with-trade-i/
// ═══════════════════════════════════════════════════════

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";

        ArrayList<Character> type = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        for (char c : t.toCharArray()) {
            if (type.isEmpty() || type.get(type.size() - 1) != c) {
                type.add(c);
                len.add(1);
            } else {
                len.set(len.size() - 1, len.get(len.size() - 1) + 1);
            }
        }

        int best = 0;

        for (int i = 1; i + 1 < type.size(); i++) {
            if (type.get(i) == '1' &&
                type.get(i - 1) == '0' &&
                type.get(i + 1) == '0') {

                best = Math.max(best, len.get(i - 1) + len.get(i + 1));
            }
        }

        return ones + best;
    }
}
