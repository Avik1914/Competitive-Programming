/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Notice that you may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

0 <= k <= 109
0 <= prices.length <= 104
0 <= prices[i] <= 1000
*/

class Solution {
    public int maxProfit(int t, int[] prices) {
        int len=prices.length;
        int res=0;
        if(t>=len/2){
            for(int i=1;i<len;i++){
                if(prices[i]>prices[i-1])
                    res+=prices[i]-prices[i-1];
            }
            return res;
        }
        int[][] dp=new int[t+1][len];
        
        for(int i=1;i<=t;i++){
            int max=-prices[0];
            for(int j=1;j<len;j++){
                dp[i][j]=Math.max(dp[i][j-1],max+prices[j]);
                max=Math.max(dp[i-1][j]-prices[j],max);
                res=Math.max(res,dp[i][j]);
            }
            
        }
        return res;
    }
    
    
}
