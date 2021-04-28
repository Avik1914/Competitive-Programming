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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp=head;
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        ListNode ret=newHead;
        while(left-->1){
            right--;
            newHead=temp;
            temp=temp.next;
        }
        //newHead.next=null;
        ListNode start=temp;
        
        while(temp!=null){
            right--;
            ListNode prev=temp.next;
            temp.next=newHead.next;
            newHead.next=temp;
            if(right==0){
                start.next=prev;
                break;
            }
            temp=prev;
        }
        
        return ret.next;
    }
}