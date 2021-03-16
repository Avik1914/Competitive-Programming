class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int[] buy=new int[len];
        int[] sell=new int[len];
        buy[0]=-prices[0];
        int res=0;
        for(int i=1;i<len;i++){
            buy[i]=Math.max(buy[i-1],-prices[i]);
            sell[i]=Math.max(prices[i]+buy[i-1],0);
            
            res=Math.max(sell[i],res);
        }
        
        return res;
    }
}