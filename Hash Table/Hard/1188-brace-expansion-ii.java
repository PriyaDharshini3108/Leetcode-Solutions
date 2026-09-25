// ═══════════════════════════════════════════════════════
// Problem: 1188. Brace Expansion II
// Difficulty: Hard
// Topics: Hash Table, String, Backtracking, Stack, Breadth-First Search, Sorting
// Runtime: 32 ms (Beats 8.0%)
// Memory: 52.9 MB (Beats 8.8%)
// Submitted: Sep 25, 2026
// Link: https://leetcode.com/problems/brace-expansion-ii/
// ═══════════════════════════════════════════════════════

class Solution {
    TreeSet<String> ans = new TreeSet<>();

    void dfs(String s) {
        int r = s.indexOf('}');

        // No braces left
        if (r == -1) {
            ans.add(s);
            return;
        }

        // Find matching '{'
        int l = s.lastIndexOf('{', r);

        String left = s.substring(0, l);
        String right = s.substring(r + 1);

        // Content inside { }
        String inside = s.substring(l + 1, r);

        for (String part : inside.split(",")) {
            dfs(left + part + right);
        }
    }

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(ans);
    }
}
