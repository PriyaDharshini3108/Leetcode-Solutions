// ═══════════════════════════════════════════════════════
// Problem: 4107. Find Missing Elements
// Difficulty: Easy
// Topics: Array, Hash Table, Sorting
// Runtime: 7 ms (Beats 22.5%)
// Memory: 47.1 MB (Beats 33.5%)
// Submitted: Aug 4, 2026
// Link: https://leetcode.com/problems/find-missing-elements/
// ═══════════════════════════════════════════════════════

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);

        int currEle = nums[0];

        for(int i = 0 ; i < nums.length ; currEle++, i++){
            if(currEle < nums[i]){
                res.add(currEle);
                i--;
            }
        }

        return res;
    }
}
