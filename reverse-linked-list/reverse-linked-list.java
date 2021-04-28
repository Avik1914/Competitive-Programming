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
    ListNode ret=null;
    public ListNode reverseList(ListNode head) {
        newHead=null;
        dfs(head);
        return ret;
    }
    
    public void dfs(ListNode head){
        if(head==null)
            return;
        dfs(head.next);
        if(newHead==null){
            newHead=head;
            ret=head;
        }else{
            newHead.next=head;
            newHead=head;
        }
        newHead.next=null;
    }
}