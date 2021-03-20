class Solution {
    Random rand;
   
    int[] nums;
    public Solution(int[] nums) {
        rand=new Random();
        
        this.nums=nums;
    }
    
    public int pick(int target) {
        int ans=-1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=target)
                continue;
            count++;
            if(rand.nextInt(count)==0)
                ans=i;
                
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */