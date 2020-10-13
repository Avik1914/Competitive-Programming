/*
Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
*/

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
    public ListNode sortList(ListNode head) {
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null)
            return head;
        
        ListNode fast=head.next;
        ListNode slow=head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
      
        }
        ListNode one=mergeSort(slow.next);
        slow.next=null;
        ListNode two=mergeSort(head);
        return merge(one,two);
    }
    
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode head=new ListNode(-1);
        ListNode run=head;
        while(l1!=null || l2!=null){
            if(l1==null){
                run.next=l2;
                l2=l2.next;
            }else if(l2==null){
                run.next=l1;
                l1=l1.next;
            }else if(l1.val<l2.val){
                run.next=l1;
                l1=l1.next;
            }else{
                run.next=l2;
                l2=l2.next;
            }
            run=run.next;
        }
        return head.next;
    }
}
