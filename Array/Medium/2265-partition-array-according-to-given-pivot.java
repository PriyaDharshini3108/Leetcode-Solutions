// ═══════════════════════════════════════════════════════
// Problem: 2265. Partition Array According to Given Pivot
// Difficulty: Medium
// Topics: Array, Two Pointers, Simulation
// Runtime: 5 ms (Beats 73.6%)
// Memory: 160.2 MB (Beats 21.2%)
// Submitted: Jun 8, 2026
// Link: https://leetcode.com/problems/partition-array-according-to-given-pivot/
// ═══════════════════════════════════════════════════════

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int[]arr=new int[n];
        int index=0;
        for(int val:nums){
            if(val<pivot)arr[index++]=val;
        }
        for(int val:nums){
            if(val==pivot)arr[index++]=val;
        }
        for(int val:nums){
            if(val>pivot)arr[index++]=val;
        }
        return arr;
    }
}
