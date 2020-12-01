class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int len=nums.length;
        int[] dpLeft=new int[len];
        int[] dpRight=new int[len];
        Arrays.fill(dpLeft,1);
        Arrays.fill(dpRight,1);
        
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    dpLeft[i]=Math.max(dpLeft[i],1+dpLeft[j]);
            }
        }
        
        for(int i=len-1;i>=0;i--){
            for(int j=len-1;j>i;j--){
                if(nums[j]<nums[i])
                    dpRight[i]=Math.max(dpRight[i],1+dpRight[j]);
            }
        }
        int res=0;
        for(int i=1;i<len-1;i++){
            if(dpLeft[i]>1 && dpRight[i]>1)
                res=Math.max(res,dpLeft[i]+dpRight[i]-1);
        }
        return len-res;
    }
}
