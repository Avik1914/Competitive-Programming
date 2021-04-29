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
    public ListNode swapPairs(ListNode head) {
        
        if(head!=null && head.next!=null){
            ListNode after=head.next.next;
            head.next.next=head;
            ListNode ret=head.next;
            head.next=swapPairs(after);
            return ret;
        }
        return head;
    }
    
}