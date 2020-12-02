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
​
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    int len;
    ListNode root;
    public Solution(ListNode head) {
        len=0;
        root=head;
        while(head!=null){
            len++;
            head=head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random(); 
        int ind=rand.nextInt(len);
        ListNode temp=root;
        while(ind-->0)
            temp=temp.next;
        return temp.val;
        
    }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
