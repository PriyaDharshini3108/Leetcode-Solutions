// ═══════════════════════════════════════════════════════
// Problem: 3236. Smallest Missing Integer Greater Than Sequential Prefix Sum
// Difficulty: Easy
// Topics: Array, Hash Table, Sorting
// Runtime: 2 ms (Beats 52.9%)
// Memory: 44.3 MB (Beats 23.3%)
// Submitted: Aug 11, 2026
// Link: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/
// ═══════════════════════════════════════════════════════

class Solution {
    public int missingInteger(int[] A) {
        int n = A.length;
        Set<Integer> seen = new HashSet<>(n);

        for (int num : A)
            seen.add(num);
        int sum = A[0];

        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1] + 1)
                sum += A[i];
            else break;
        }

        while (seen.contains(sum))
            sum++;

        return sum;
    }
}
