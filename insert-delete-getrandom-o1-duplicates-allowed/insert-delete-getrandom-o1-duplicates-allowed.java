class RandomizedCollection {
    List<Integer> li;
    Map<Integer,HashSet<Integer>> map;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map=new HashMap();
        li=new ArrayList();
        rand=new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res=!map.containsKey(val);
        if(res)
            map.put(val,new HashSet());
        map.get(val).add(li.size());
        li.add(val);
        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        HashSet<Integer> st=map.get(val);
        if(st.size()==1)
            map.remove(val);
        Integer ind=0;
        for(Integer a:st){
            ind=a;
            break;
        }
        st.remove(ind);
        li.set(ind,li.get(li.size()-1));
        st=map.get(li.get(li.size()-1));
        if(st!=null){
            st.remove(new Integer(li.size()-1));
            st.add(ind);
        }
        li.remove(li.size()-1);
        
        return true;
            
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int x=rand.nextInt(li.size());
        return li.get(x);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */