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
    private ListNode merge(ListNode temp1, ListNode temp2) {
    ListNode dummy = new ListNode(-1);
    ListNode temp = dummy;

    while(temp1!=null && temp2!=null) {
        if(temp1.val<=temp2.val) {
            temp.next = temp1;
            temp1 = temp1.next;
        }
        else {
            temp.next = temp2;
            temp2 = temp2.next;
        }
        temp = temp.next;
    }
        
        if(temp1==null) temp.next = temp2;
        else temp.next = temp1;

        return dummy.next;
    }   

    public ListNode sortList(ListNode temp) {

    ListNode slow = temp;
    ListNode fast = temp;
    ListNode a = temp;
    
    if(temp==null || temp.next==null) return temp;

    while(fast.next!=null && fast.next.next!=null) {
        slow=slow.next;
        fast=fast.next.next;
    }
    ListNode b = slow.next;
    slow.next = null;
    
    a = sortList(a);
    b = sortList(b);
    ListNode ans = merge(a,b);
    return ans;
    }
}