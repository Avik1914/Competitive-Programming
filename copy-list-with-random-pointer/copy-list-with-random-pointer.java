/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node dummy;
        Node run=head;
        
        while(run!=null){
            dummy=new Node(run.val);
            dummy.next=run.next;
            run.next=dummy;
            run=run.next.next;
        }
        run=head;
    
        while(run!=null){
            run.next.random=run.random==null?null:run.random.next;
            run=run.next.next;
        }
        Node oldList=head;
        Node newList=head.next;
        Node ans=head.next;
        while(oldList!=null){
            oldList.next=oldList.next.next;
            if(newList.next!=null){
                newList.next=newList.next.next;
                newList=newList.next;
            }
            oldList=oldList.next;
            
        }
        
        return ans;
    }
}