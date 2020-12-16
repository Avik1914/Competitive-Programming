/*
Given a non-negative integer represented as a linked list of digits, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list.

 

Example 1:

Input: head = [1,2,3]
Output: [1,2,4]
Example 2:

Input: head = [0]
Output: [1]
 

Constraints:

The number of nodes in the linked list is in the range [1, 100].
0 <= Node.val <= 9
The number represented by the linked list does not contain leading zeros except for the zero itself. 
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
    public ListNode plusOne(ListNode head) {
        int val=dfs(head);
        if(val==0)
            return head;
        ListNode newHead=new ListNode(val);
        newHead.next=head;
        return newHead;
    }
    
    public int dfs(ListNode head){
        if(head==null)
            return 1;
        int val=dfs(head.next);
        int nVal=head.val+val;
        head.val=nVal%10;
        return nVal/10;
    }
}
