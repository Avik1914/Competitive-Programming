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
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        
        while(l1!=null){
            stack1.add(l1.val);
            l1=l1.next;
        }
        
        while(l2!=null){
            stack2.add(l2.val);
            l2=l2.next;
        }
        
        ListNode li=new ListNode(-1);
        int sum=0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            sum+=stack1.isEmpty()?0:stack1.pop();
            sum+=stack2.isEmpty()?0:stack2.pop();
            li.val=sum%10;
            ListNode head=new ListNode(sum/10);
            sum=sum/10;
            head.next=li;
            li=head;
        }
        
        return sum==0?li.next:li;
    }
}