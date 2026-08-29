// ═══════════════════════════════════════════════════════
// Problem: 3219. Make Lexicographically Smallest Array by Swapping Elements
// Difficulty: Medium
// Topics: Array, Union-Find, Sorting
// Runtime: 69 ms (Beats 95.5%)
// Memory: 209.8 MB (Beats 25.8%)
// Submitted: Aug 29, 2026
// Link: https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
// ═══════════════════════════════════════════════════════

class Solution {
    public int[] lexicographicallySmallestArray(int[] A, int limit) {
        int[] srt = A.clone();
        Arrays.sort(srt);
        List<List<Integer>> grps = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int id = -1;

        for (int i = 0; i < srt.length; i++) {
            if (i == 0 || srt[i] - srt[i - 1] > limit) {
                grps.add(new ArrayList<>());
                id++;
            }
            
            grps.get(id).add(srt[i]);
            map.put(srt[i], id);
        }

        int[] idx = new int[grps.size()];

        for (int i = 0; i < A.length; i++) {
            int cur = map.get(A[i]);
            A[i] = grps.get(cur).get(idx[cur]);
            idx[cur]++;
        }

        return A;
    }
}
