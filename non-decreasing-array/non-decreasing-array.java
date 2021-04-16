class Solution {
    public boolean checkPossibility(int[] nums) {
        int len=nums.length;
        int max=Integer.MIN_VALUE;
        int change=0;
        
        for(int i=0;i<len-1;i++){
            if(nums[i]>nums[i+1]){
                if(max<=nums[i+1]){
                    max=nums[i+1];
                    
                }else{
                    nums[i+1]=nums[i];
                    max=Math.max(nums[i],max);
                }
                change++;
                    
            }else
                max=Math.max(nums[i],max);
            if(change>1)
                return false;
            
        }
        return true;
    }
}