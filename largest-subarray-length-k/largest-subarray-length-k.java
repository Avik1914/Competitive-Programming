class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int len=nums.length;
        int start=0;
        int end=k-1;
        int itr=0;
        int itr1=k-1;
        while(itr1<len){
            if(nums[itr]>nums[start]){
                start=itr;
                end=itr+k-1;
            }else if(nums[itr]==nums[start] && nums[itr+k-1]>nums[end]){
                start=itr;
                end=itr+k-1;
            }
            itr++;
            itr1++;
        }
        int[] res=new int[k];
       // System.out.println(start+","+end);
        itr=0;
        for(int i=start;i<=end;i++){
            res[itr++]=nums[i];
        }
        return res;
    }
}
