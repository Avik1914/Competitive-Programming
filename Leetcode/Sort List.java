/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
            return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null) 
            return head;
        
        ListNode mid=getMiddleNode(head);
        ListNode temp=mid.next;
        mid.next=null;
        ListNode left=mergeSort(head);
        ListNode right=mergeSort(temp);
        return mergeTwoLists(left,right);
    }
    
     public ListNode getMiddleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1.val>l2.val){
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
        else{
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        
    }
}
