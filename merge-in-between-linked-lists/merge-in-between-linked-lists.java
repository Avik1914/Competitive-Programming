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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode run=list1;
        ListNode last=list2;
        ListNode temp=null;
        
        while(run!=null){
            a--;
            b--;
            if(a==0){
                temp=run.next;
                run.next=list2;
                while(list2!=null){
                    last=list2;
                    list2=list2.next;
                }
                run=temp;
            }else
                run=run.next;
            if(b==0 && run!=null){
                last.next=run.next;
                break;
            }
        }
        return list1;
    }
}
