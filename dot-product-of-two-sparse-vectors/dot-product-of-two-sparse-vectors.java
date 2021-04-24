class SparseVector {
    LinkedHashMap<Integer,Integer> map;
    SparseVector(int[] nums) {
        map=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                map.put(i,nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
            List<Integer> res2=new ArrayList(vec.map.keySet());
            List<Integer> res1=new ArrayList(map.keySet());
            
            int i=res1.size(),j=res2.size();
            int itr1=0,itr2=0;
        int res=0;
        while(itr1<i && itr2<j){
            int a=res1.get(itr1);
            int b=res2.get(itr2);
            if(a==b){
                res+=map.get(a)*vec.map.get(b);
                itr1++;
                itr2++;
            }
            else if(a<b)
                itr1++;
            else
                itr2++;
        }
        
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);