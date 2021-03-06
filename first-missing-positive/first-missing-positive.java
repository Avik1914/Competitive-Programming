class Solution {
    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        int max=0;
        
        for(int i=0;i<len;i++){
            if(nums[i]>0 && nums[i]<=len){
                int temp=nums[i];
                while(temp>0 && temp<=len && nums[temp-1]!=temp){
                    int val=nums[temp-1];
                    nums[temp-1]=temp;
                    temp=val;
                }
            }
        }
        
        for(int i=0;i<len;i++){
            
            if(i+1!=nums[i])
                return i+1;
        }
        
        return len+1;
    }
}