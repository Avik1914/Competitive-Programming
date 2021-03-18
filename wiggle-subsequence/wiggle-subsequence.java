class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len=nums.length;
        int[] up=new int[len];
        int[] down=new int[len];
        int res=1;
        up[0]=1;
        down[0]=1;
        for(int i=1;i<len;i++){
            if(nums[i-1]>nums[i]){
                down[i]=up[i-1]+1;
                up[i]=up[i-1];
            }else if(nums[i-1]<nums[i]){
                up[i]=1+down[i-1];
                down[i]=down[i-1];
            }else{
                up[i]=up[i-1];
                down[i]=down[i-1];
            }
            res=Math.max(up[i],down[i]);
        }
        return res;
    }
}