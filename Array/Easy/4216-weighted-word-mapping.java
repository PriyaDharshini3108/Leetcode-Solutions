// ═══════════════════════════════════════════════════════
// Problem: 4216. Weighted Word Mapping
// Difficulty: Easy
// Topics: Array, String, Simulation
// Runtime: 2 ms (Beats 96.9%)
// Memory: 46.7 MB (Beats 21.3%)
// Submitted: Jun 13, 2026
// Link: https://leetcode.com/problems/weighted-word-mapping/
// ═══════════════════════════════════════════════════════

class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            int sumWeight = 0;
            
            for (char ch : word.toCharArray()) {
                sumWeight += weights[ch - 'a'];
            }
            
            int value = sumWeight % 26;
            
            result.append((char)('z' - value));
        }
        
        return result.toString();
    }
}
