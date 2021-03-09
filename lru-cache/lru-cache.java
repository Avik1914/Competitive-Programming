class Node{
    int val,key;
    Node next,prev;
    Node(int val,int key){
        this.key=val;
        this.val=key;
        next=null;
        prev=null;
    }
}

class Dlist{
    Node head,tail;
    Dlist(){
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public void add(Node n){
        head.next.prev=n;
        n.next=head.next;
        n.prev=head;
        head.next=n;
    }
}
class LRUCache {
    int capacity;
    Dlist doublyList;
    Map<Integer,Node> nodeMap;
    
    public LRUCache(int capacity) {
        nodeMap=new HashMap();
        this.capacity=capacity;
        doublyList=new Dlist();
    }
    
    public int get(int key) {
        Node node=nodeMap.get(key);
        if(node==null)
            return -1;
        updateRecent(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node n=null;
        if(!nodeMap.containsKey(key)){
            n=new Node(key,value);
            nodeMap.put(key,n);
            capacity--;
            doublyList.add(n);
        }else{
            n=nodeMap.get(key);
            n.val=value;
            updateRecent(n);
        }
        
        if(capacity<0)
            remove();
    }
    
    public void updateRecent(Node m){
        m.prev.next=m.next;
        m.next.prev=m.prev;
        
        doublyList.head.next.prev=m;
        m.next=doublyList.head.next;
        doublyList.head.next=m;
        m.prev=doublyList.head;
        
        
    }
    
    public void remove(){
        int key=doublyList.tail.prev.key;
        doublyList.tail.prev.prev.next=doublyList.tail;
        doublyList.tail.prev=doublyList.tail.prev.prev;
        nodeMap.remove(key);
        capacity++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */