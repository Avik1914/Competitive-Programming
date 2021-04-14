/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
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
    public ListNode partition(ListNode head, int x) {
        ListNode l1=new ListNode(-1);
        ListNode l2=new ListNode(-1);
        
        ListNode l1Run=l1,l2Run=l2;
        
        while(head!=null){
            ListNode temp=head.next;
            
            if(head.val<x){
                l1Run.next=head;
                l1Run=l1Run.next;
                l1Run.next=null;
            }else{
                l2Run.next=head;
                l2Run=l2Run.next;
                l2Run.next=null;
            }
            head=temp;
        }
        l1Run.next=l2.next;
        return l1.next;
    }
}
