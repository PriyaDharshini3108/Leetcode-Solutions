// ═══════════════════════════════════════════════════════
// Problem: 4057. Total Waviness of Numbers in Range I
// Difficulty: Medium
// Topics: Math, Dynamic Programming, Enumeration
// Runtime: 34 ms (Beats 15.6%)
// Memory: 46.4 MB (Beats 52.0%)
// Submitted: Jun 4, 2026
// Link: https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/
// ═══════════════════════════════════════════════════════

class Solution {
    public int totalWaviness(int num1, int num2) {
        int waviness = 0;
        for (int i = num1; i <= num2; i++) {
            ArrayList<Integer> digits = new ArrayList<>();
            int num = i;
            digits = getDigits(digits, num);;
            for(int j = 1; j < digits.size()-1; j++) {
                if((digits.get(j) > digits.get(j+1) && digits.get(j) > digits.get(j-1)) ||
                        (digits.get(j) < digits.get(j+1) && digits.get(j) < digits.get(j-1))){
                    waviness++;
                }
            }
        }
        return waviness;
    }

    private ArrayList<Integer> getDigits(ArrayList<Integer> digits, int num) {
        if (num == 0) return digits;
        if(num > 0) {
            getDigits(digits, num / 10);
            digits.add(num % 10);
        }
        return digits;
    }
}
