class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int len=nums.length;
        int sum=0;
        int res=0;
        Set<Integer> set=new HashSet();
        int start=0;
        for(int i=0;i<len;i++){
            while(set.contains(nums[i])){
                sum-=nums[start];
                set.remove(nums[start]);
                start++;
            }
            sum+=nums[i];
            res=Math.max(res,sum);
            set.add(nums[i]);
        }
        
        return res;
    }
}
