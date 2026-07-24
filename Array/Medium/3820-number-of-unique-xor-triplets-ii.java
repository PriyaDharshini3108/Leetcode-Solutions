// ═══════════════════════════════════════════════════════
// Problem: 3820. Number of Unique XOR Triplets II
// Difficulty: Medium
// Topics: Array, Math, Bit Manipulation, Enumeration
// Runtime: 177 ms (Beats 98.2%)
// Memory: 47 MB (Beats 63.6%)
// Submitted: Jul 24, 2026
// Link: https://leetcode.com/problems/number-of-unique-xor-triplets-ii/
// ═══════════════════════════════════════════════════════

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX_XOR = 2048;

        boolean[] pairXor = new boolean[MAX_XOR];
        boolean[] tripletXor = new boolean[MAX_XOR];

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        for (int x = 0; x < MAX_XOR; x++) {
            if (!pairXor[x]) continue;

            for (int v : nums) {
                tripletXor[x ^ v] = true;
            }
        }

        int count = 0;
        for (boolean exists : tripletXor) {
            if (exists) count++;
        }

        return count;
    }
}
