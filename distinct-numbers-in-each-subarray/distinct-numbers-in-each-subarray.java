class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int len=nums.length;
        
        int[] res=new int[len-k+1];
        int start=0;
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);    
            if(i>=k){
                if(map.get(nums[start])==1)
                    map.remove(nums[start]);
                else
                    map.put(nums[start],map.get(nums[start])-1);
                start++;
            }
            if(i>=k-1)
                res[i-k+1]=map.size();
                
        }
        
        return res;
    }
}