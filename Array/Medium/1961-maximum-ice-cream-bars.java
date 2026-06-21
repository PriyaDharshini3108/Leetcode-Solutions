// ═══════════════════════════════════════════════════════
// Problem: 1961. Maximum Ice Cream Bars
// Difficulty: Medium
// Topics: Array, Greedy, Sorting, Counting Sort
// Runtime: 9 ms (Beats 81.7%)
// Memory: 81.9 MB (Beats 97.9%)
// Submitted: Jun 21, 2026
// Link: https://leetcode.com/problems/maximum-ice-cream-bars/
// ═══════════════════════════════════════════════════════

class Solution {
    public int maxIceCream(int[] costs, int coins) {

        final int MAX_COST = 100000;

        int[] freq = new int[MAX_COST + 1];

        for (int cost : costs) {
            freq[cost]++;
        }

        int answer = 0;

        for (int cost = 1; cost <= MAX_COST; cost++) {

            if (freq[cost] == 0) {
                continue;
            }

            int canBuy = Math.min(freq[cost], coins / cost);

            answer += canBuy;

            coins -= canBuy * cost;
        }

        return answer;
    }
}
