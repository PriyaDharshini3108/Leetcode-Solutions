// ═══════════════════════════════════════════════════════
// Problem: 3931. Process String with Special Operations I
// Difficulty: Medium
// Topics: String, Simulation
// Runtime: 4 ms (Beats 76.5%)
// Memory: 55.5 MB (Beats 36.8%)
// Submitted: Jun 16, 2026
// Link: https://leetcode.com/problems/process-string-with-special-operations-i/
// ═══════════════════════════════════════════════════════

class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == '*' && ans.length() >= 1) {
                ans.deleteCharAt(ans.length() - 1);
            }
            else if(ch == '#' && ans.length() >= 1) {
                String temp = ans.toString();
                ans.append(temp);
            }
            else if(ch == '%') {
                ans.reverse();
            }
            if(ch >= 'a' && ch <= 'z') {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
