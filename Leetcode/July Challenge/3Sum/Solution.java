/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum=0;
        int len=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList();
        
        for(int i=0;i<len;){
            int lo=i+1;
            int hi=len-1;
            while(lo<hi){
                int val=nums[i]+nums[lo]+nums[hi];
                int l1=nums[lo];
                int l2=nums[hi];
                if(val==0){
                    List<Integer> perRes=new ArrayList();
                    perRes.add(nums[i]);
                    perRes.add(nums[lo]);
                    perRes.add(nums[hi]);
                    res.add(perRes);
                    lo++;
                    hi--;
                     
                    while(lo<hi && nums[lo]==l1 && nums[hi]==l2){
                        lo++;
                        hi--;
                    }
                }else if(val<0)
                    lo++;
                else
                    hi--;
            }
             int n=nums[i];
             while(i==len-1 || (i<len && nums[i]==n))
              i++;
        }
        return res;
    }
}
