/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/

class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len==0)
            return 0;
        int max=prices[len-1];
        int res=0;
        int maxRes=0;
        int[] dp=new int[len];
        
        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                    dp[i]=Math.max(dp[i],prices[j]-prices[i]+(j+2<len?dp[j+2]:0));
                    res=Math.max(res,dp[i]);
            }
            if(i+1<len)
                dp[i]=Math.max(dp[i],dp[i+1]);
        }
        return res;
    }
}
