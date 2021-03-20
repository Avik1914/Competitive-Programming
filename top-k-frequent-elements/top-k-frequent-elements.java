class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len=nums.length;
        
        Set<Integer>[] bucket=new HashSet[len+1];
        Map<Integer,Integer> map=new HashMap();
        bucket[0]=new HashSet();
        for(int i=0;i<len;i++){
            bucket[i+1]=new HashSet();
            int val=map.getOrDefault(nums[i],0);
            bucket[val].remove(new Integer(nums[i]));
            bucket[val+1].add(nums[i]);
            map.put(nums[i],val+1);
        }
        int itr=len;
        
        int[] res=new int[k];
        while(itr>=0 && k>0){
            if(!bucket[itr].isEmpty()){
                for(int val:bucket[itr]){
                    res[--k]=val;
                    if(k==0)
                        return res;
                }
            }
            itr--;
        }
        return res;
        
    }
}