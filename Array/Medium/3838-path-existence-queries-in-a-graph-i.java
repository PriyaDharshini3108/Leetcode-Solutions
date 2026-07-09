// ═══════════════════════════════════════════════════════
// Problem: 3838. Path Existence Queries in a Graph I
// Difficulty: Medium
// Topics: Array, Hash Table, Binary Search, Union-Find, Graph Theory
// Runtime: 3 ms (Beats 97.0%)
// Memory: 163.1 MB (Beats 59.4%)
// Submitted: Jul 9, 2026
// Link: https://leetcode.com/problems/path-existence-queries-in-a-graph-i/
// ═══════════════════════════════════════════════════════

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[n];
        comp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                comp[i] = comp[i - 1];
            } else {
                comp[i] = comp[i - 1] + 1;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = (comp[u] == comp[v]);
        }

        return ans;
    }
}
