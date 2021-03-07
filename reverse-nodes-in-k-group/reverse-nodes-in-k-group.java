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
    ListNode localHead;
    ListNode localTail;
    ListNode newHead=null;
    public ListNode reverseKGroup(ListNode head, int k) {
        localTail=null;
        while(head!=null){
            int itr=k;
            ListNode val=head;
            while(itr-->0 && val!=null)
                val=val.next;
            if(itr>=0){
                if(localTail!=null)
                    localTail.next=head;
                else
                    return head;
                break;
            }
            localHead=null;
            ListNode tail=reverse(head,k);
            if(localTail!=null)
                localTail.next=localHead;
            localTail=tail;
            head=val;
            if(newHead==null)
                newHead=localHead;
        }
        
        return newHead;
    }
    
    public ListNode reverse(ListNode li,int k){
        if(k==0 || li==null)
            return null;
        ListNode node=reverse(li.next,k-1);
        if(node==null)
            localHead=li;
        else
            node.next=li;
        li.next=null;
        return li;
    }
}