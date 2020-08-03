/*
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.
*/


class MyHashSet {
    LinkedList[] buckets;
    int mod=1119;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=new LinkedList[mod];
        for(int i=0;i<mod;i++)
            buckets[i]=new LinkedList();
    }
    
    public void add(int key) {
        //System.out.println(1);
        buckets[key%1119].add(key);
    }
    
    public void remove(int key) {
        //System.out.println(2);
        Iterator itr=buckets[key%mod].iterator();
        while(itr.hasNext()){
            if((int)itr.next()==key)
                itr.remove();
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        //System.out.println(3);
        return buckets[key%mod].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
