class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int len=nums.length;
        
        int i=start,j=start;
        while(i>=0 || j<len){
            if(i>=0 && j<len){
                if(nums[i]==target)
                    return start-i;
                else if(nums[j]==target)
                    return j-start;
                i--;
                j++;
            }else if(i<0){
                if(nums[j]==target)
                    return j-start;
                j++;
            }else{
                if(nums[i]==target)
                    return start-i;
                i--;
            }
        }
        
        return -1;
    }
}