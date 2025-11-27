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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s=head;
        List<Integer>list=new ArrayList<>();
        while(s!=null){
            list.add(s.val);
            s=s.next;
        }
        ListNode head1=null;
        ListNode tail=null;
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(i!=list.size()-n){
                ListNode n1=new ListNode(list.get(i));
                if(head1==null){
                    head1=n1;
                    tail=n1;
                }
                else{
                    tail.next=n1;
                    tail=n1;
                }
            }
        }
        return head1;
    }
}