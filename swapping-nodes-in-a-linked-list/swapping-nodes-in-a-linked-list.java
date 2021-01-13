/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int cnt=0;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode temp=dummy;
        ListNode after=dummy;
        ListNode before=dummy;
        while(temp!=null && temp.next!=null){
            temp=temp.next;
            cnt++;
            if(cnt>=k){
                if(cnt==k)
                    before=temp;
                    after=after.next;
            }
        }
        int val=after.val;
        after.val=before.val;
        before.val=val;
        return head;
    }
}
