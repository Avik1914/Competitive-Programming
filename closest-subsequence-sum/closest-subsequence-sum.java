class Solution {
    
    public int minAbsDifference(int[] nums, int goal) {
        int sum=0;
        List<Integer> one=new ArrayList();
        List<Integer> two=new ArrayList();
        
        int len=nums.length-1;
        
        dfs(nums,0,len/2,0,one);
        dfs(nums,(len/2)+1,len,0,two);
        
        //Collections.sort(one);
        Collections.sort(two);
        
        int res=Integer.MAX_VALUE;
        for(int i=0;i<one.size();i++){
            int lo=0;
            int hi=two.size()-1;
            int target=goal-one.get(i);
            while(lo<=hi){
                int mid=(lo+hi)/2;
                res=Math.min(Math.abs(target-two.get(mid)),res);
                if(two.get(mid)==target)
                    return 0;
                if(two.get(mid)<target)
                    lo=mid+1;
                else
                    hi=mid-1;                
            }
        }
        
        return res;
    }
    
    
    public void dfs(int[] nums,int lo,int hi,int sum,List<Integer> li){
        if(lo>hi){
            li.add(sum);
            return;
        }
        dfs(nums,lo+1,hi,sum,li);
        dfs(nums,lo+1,hi,sum+nums[lo],li);
        
    }
}