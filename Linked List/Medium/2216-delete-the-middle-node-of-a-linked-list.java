// ═══════════════════════════════════════════════════════
// Problem: 2216. Delete the Middle Node of a Linked List
// Difficulty: Medium
// Topics: Linked List, Two Pointers
// Runtime: 4 ms (Beats 19.3%)
// Memory: 202.5 MB (Beats 59.6%)
// Submitted: Jun 15, 2026
// Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
// ═══════════════════════════════════════════════════════

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null)return null;
        ListNode slow=head;
        ListNode fast=head;
        ListNode preSlow=null;
        while(fast!=null&&fast.next!=null){
            preSlow=slow;
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)break;
        }
        preSlow.next=slow.next;
        return head;
    }
}
