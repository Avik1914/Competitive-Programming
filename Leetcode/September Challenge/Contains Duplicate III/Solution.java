/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len=nums.length;
        if(t<0 || k<0)
            return false;
        TreeSet<Long> set=new TreeSet();
        int itr=0;
        long val;
        for(int i=0;i<len;i++){
            long diff=(long)nums[i]-(long)t;
            long add=(long)nums[i]+(long)t;
            Long a=set.ceiling(diff);
            Long b=set.floor(add);
            if(a!=null){
                val=Math.abs((long)nums[i]-a);
                if(val<=t)
                    return true;
            }
            if(b!=null){
                val=Math.abs((long)nums[i]-b);
                if(val<=t)
                    return true;
            }
            set.add((long)nums[i]);
            if(itr==k){
                set.remove((long)nums[i-itr]);
                itr--;
            }
            itr++;
        }
        return false;
    }
}
