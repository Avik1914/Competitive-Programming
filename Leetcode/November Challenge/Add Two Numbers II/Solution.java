/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1=getLen(l1);
        int len2=getLen(l2);
        ListNode root=len1>len2?helper(l1,l2,len1-len2):helper(l2,l1,len2-len1);
        if(root!=null && root.val>9){
            ListNode nr=new ListNode(1);
            root.val=root.val%10;
            nr.next=root;
            root=nr;
        }
        return root;
    }
    
    public ListNode helper(ListNode l1,ListNode l2,int offSet){
        if(l1==null)
            return null;
        if(offSet==0){
             l1.next=helper(l1.next,l2.next,offSet);
             l1.val+=l2.val;
        }else
                l1.next=helper(l1.next,l2,offSet-1);
        
        if(l1.next!=null && l1.next.val>9){
            l1.next.val=l1.next.val%10;
            l1.val+=1;
        }
        return l1;
    }
    
    public int getLen(ListNode l1){
        if(l1==null)
            return 0;
        return 1+getLen(l1.next);
    }
}
