class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int[] buy=new int[len+1];
        int[] sell=new int[len+1];
        buy[1]=-prices[0];
        int res=0;
        for(int i=1;i<len;i++){
            buy[i+1]=Math.max(buy[i],-prices[i]+sell[i-1]);
            sell[i+1]=Math.max(prices[i]+buy[i],sell[i]);
            
            res=Math.max(sell[i+1],res);
        }
        
        return res;
    }
}