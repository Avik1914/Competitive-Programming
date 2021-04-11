class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int loc=0;
        int len=nums.length;
        
        for(int i=0;i<len-1;i++){
            if(nums[i]>nums[i+1])
                loc++;
        }
        int maxVal=0;
        int[] max=new int[len];
        
        for(int i=0;i<len;i++){
            maxVal=Math.max(nums[i],maxVal);
            max[i]=maxVal;
        }
        int minVal=Integer.MAX_VALUE;
        
        for(int i=len-1;i>=2;i--){
            minVal=Math.min(nums[i],minVal);
            if(minVal<max[i-2])
                return false;
        }
        
        return true;
    }
}