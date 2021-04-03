class Dlist{
    Dlist next;
    Dlist prev;
    int key;
    int val;
    Dlist(int key,int val){
        next=null;
        prev=null;
        this.val=val;
        this.key=key;
    }
}

class LRUCache {
    int size;
    Map<Integer,Dlist> map;
    Dlist head;
    Dlist tail;
    
    public LRUCache(int capacity) {
        size=capacity;
        map=new HashMap();
        Dlist dummy=new Dlist(-1,-1);
        head=dummy;
        tail=dummy;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))    
            return -1;
        changePriority(key);
        return map.get(key).val;
    }
    
    public void changePriority(int key){
        Dlist temp=map.get(key);
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        addFirst(key);
    }
    
    public void addFirst(int key){
        Dlist temp=map.get(key);
        head.next.prev=temp;
        temp.prev=head;
        temp.next=head.next;
        head.next=temp;
    }
    
    public void put(int key, int value) {
        Dlist temp;
        if(!map.containsKey(key)){
            size--;
            temp=new Dlist(key,value);
            map.put(key,temp);
            addFirst(key);
        }else{
            map.get(key).val=value;
            changePriority(key);
        }
        if(size<0){
            map.remove(tail.prev.key);
            tail.prev.prev.next=tail;
            tail.prev=tail.prev.prev;
            size++;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */