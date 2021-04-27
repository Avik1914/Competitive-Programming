class Dlist{
    int val;
    int key;
    Dlist next;
    Dlist prev;
    
    Dlist(int key,int val){
        this.key=key;
        this.val=val;
        next=null;
        prev=null;
    }
}
class LRUCache {
    Dlist dummyHead;
    Dlist dummyTail;
    int capacity;
    Map<Integer,Dlist> map;
    
    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity; 
        dummyHead=new Dlist(-1,-1);
        dummyTail=new Dlist(-1,-1);
        
        dummyHead.next=dummyTail;
        dummyTail.prev=dummyHead;
        
        
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Dlist ret=map.get(key);
        reorder(ret);
        return ret.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val=value;
            reorder(map.get(key));
        }
        else{
            Dlist newDlist=new Dlist(key,value);
            newDlist.next=dummyHead.next;
            dummyHead.next.prev=newDlist;
            dummyHead.next=newDlist;
            newDlist.prev=dummyHead;
            map.put(key,newDlist);
            capacity--;
            if(capacity<0){
                Dlist rem=dummyTail.prev;
                map.remove(rem.key);
                dummyTail.prev.prev.next=dummyTail;
                dummyTail.prev=dummyTail.prev.prev;
                capacity++;
            }
                
        }
    }
    
    public void reorder(Dlist list){
        list.prev.next=list.next;
        list.next.prev=list.prev;
        list.next=dummyHead.next;
        dummyHead.next.prev=list;
        dummyHead.next=list;
        list.prev=dummyHead;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */