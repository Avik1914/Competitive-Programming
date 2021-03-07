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
    ListNode newHead;
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        helper(head);
        return newHead;
    }
    
    public ListNode helper(ListNode head){
        if(head==null)
            return null;
        ListNode node=helper(head.next);
        if(node==null)
            newHead=head;
        else{
            node.next=head;
            head.next=null;
        }
        return head;
    }
}