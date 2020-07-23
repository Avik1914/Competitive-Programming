/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/


class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int len=nums.length+2;
        dp=new int[len][len];
        int[] numsArr=new int[len];
        
        for(int i=1;i<len-1;i++)numsArr[i]=nums[i-1];
        numsArr[0]=1;numsArr[len-1]=1;
        
        for(int k=3;k<=len;k++){
            for(int i=0;i<=len-k;i++){
                for(int j=i+1;j<i+k-1;j++){
                    dp[i][i+k-1]=Math.max(dp[i][i+k-1],numsArr[i]*numsArr[j]*numsArr[i+k-1]+dp[i][j]+dp[j][i+k-1]);
                }
            }
        }
        
        return dp[0][len-1];
        //return dfs(nums,0,nums.length-1);
    }
    
   /* public int dfs(int[] nums,int start,int end){
        if(start>end)
            return 0;
        int ret=0;
        if(dp[start][end]!=null)
            return dp[start][end];
        int a=start-1<0?1:nums[start-1];
        int b=end+1>=nums.length?1:nums[end+1];
        for(int i=start;i<=end;i++){
            int val1=(a*nums[i]*b)+dfs(nums,start,i-1)
                        +dfs(nums,i+1,end);
            ret=Math.max(ret,val1);
        }
        dp[start][end]=ret;
        return ret;
    }*/
}
