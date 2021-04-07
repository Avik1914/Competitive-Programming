class Solution {
    public boolean checkPossibility(int[] nums) {
        int len=nums.length;
        int prev=Integer.MIN_VALUE;
        int count=0;
        
        for(int i=0;i<len;i++){
            if(prev>nums[i]){
                if(count>0)
                    return false;
                count++;
                if(i==1)
                    prev=nums[i];
                else
                    prev=nums[i]>=nums[i-2]?nums[i]:prev;
            }else
                prev=nums[i];
                
        }
        
        return true;
    }
}