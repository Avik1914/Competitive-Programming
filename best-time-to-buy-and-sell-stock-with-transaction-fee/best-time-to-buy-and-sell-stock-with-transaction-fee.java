class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len=prices.length;
        int[] buy=new int[len];
        int[] sell=new int[len];
        int res=0;
        buy[0]=-prices[0];
        
        for(int i=1;i<len;i++){
            buy[i]=Math.max(sell[i-1]-prices[i],buy[i-1]);
            sell[i]=Math.max(prices[i]+buy[i-1]-fee,sell[i-1]);
            res=Math.max(res,sell[i]);
        }
        return res;
    }
}