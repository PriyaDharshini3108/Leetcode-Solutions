// ═══════════════════════════════════════════════════════
// Problem: 2182. Find the Minimum and Maximum Number of Nodes Between Critical Points
// Difficulty: Medium
// Topics: Linked List
// Runtime: 5 ms (Beats 40.7%)
// Memory: 105.6 MB (Beats 98.0%)
// Submitted: Aug 31, 2026
// Link: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
// ═══════════════════════════════════════════════════════

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;

        int idx = 1;

        int firstCritical = -1;
        int lastCritical = -1;
        int minDist = Integer.MAX_VALUE;

        while(cur.next != null){
            ListNode next = cur.next;

            boolean isMax = cur.val > prev.val && cur.val > next.val;
            boolean isMin = cur.val < prev.val && cur.val < next.val;

            if(isMax || isMin){
                if(lastCritical == -1){
                    firstCritical = idx;
                }
                else {
                    minDist = Math.min(minDist, idx - lastCritical);
                }

                lastCritical = idx;
            }

            prev = cur;
            cur = next;
            idx++;
        }

        if(firstCritical == -1 || firstCritical == lastCritical){
            return new int[]{-1, -1};
        }

        int maxDist = lastCritical - firstCritical;

        return new int[]{minDist, maxDist};
    }
}
