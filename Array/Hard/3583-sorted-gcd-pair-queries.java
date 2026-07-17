// ═══════════════════════════════════════════════════════
// Problem: 3583. Sorted GCD Pair Queries
// Difficulty: Hard
// Topics: Array, Hash Table, Math, Binary Search, Combinatorics, Counting, Number Theory, Prefix Sum
// Runtime: 31 ms (Beats 59.4%)
// Memory: 105.4 MB (Beats 9.4%)
// Submitted: Jul 17, 2026
// Link: https://leetcode.com/problems/sorted-gcd-pair-queries/
// ═══════════════════════════════════════════════════════

class Solution {
    public int[] gcdValues(int[] A, long[] queries) {
        int max = Arrays.stream(A).max().getAsInt();

        int[] freq = new int[max + 1];
        long[] GCD = new long[max + 1];

        for (int a : A) freq[a]++;

        for (int i = max; i > 0; i--) {
            long sum = 0, extra = 0;
            for (int j = i; j <= max; j += i) {
                sum += freq[j];
                extra += GCD[j];
            }
            GCD[i] = sum * (sum - 1) / 2 - extra;
        }

        Arrays.parallelPrefix(GCD, Long::sum);
        int n = queries.length;

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long q = queries[i];
            int l = 0, h = max + 1;
            while (l < h) {
                int m = (l + h) >>> 1;
                if (GCD[m] <= q) l = m + 1;
                else h = m;
            }
            res[i] = l;
        }

        return res;
    }
}
