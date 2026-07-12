// ═══════════════════════════════════════════════════════
// Problem: 1256. Rank Transform of an Array
// Difficulty: Easy
// Topics: Array, Hash Table, Sorting
// Runtime: 29 ms (Beats 84.5%)
// Memory: 76.7 MB (Beats 42.8%)
// Submitted: Jul 12, 2026
// Link: https://leetcode.com/problems/rank-transform-of-an-array/
// ═══════════════════════════════════════════════════════

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();

        Arrays.sort(temp);

        HashMap<Integer, Integer> rank = new HashMap<>();
        int r = 1;

        for (int num : temp) {
            if (!rank.containsKey(num)) {
                rank.put(num, r++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }

        return arr;
    }
}
