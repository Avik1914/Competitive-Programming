class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int[][] buy=new int[len][2];
        int[][] sell=new int[len][2];
        buy[0][0]=-prices[0];
        buy[0][1]=Integer.MIN_VALUE;
        int res=0;
        
        for(int i=1;i<len;i++){
            buy[i][0]=Math.max(buy[i-1][0],-prices[i]);
            buy[i][1]=Math.max(buy[i-1][1],sell[i-1][0]-prices[i]);
            
            sell[i][0]=Math.max(sell[i-1][0],prices[i]+buy[i-1][0]);
            sell[i][1]=Math.max(sell[i-1][1],prices[i]+buy[i-1][1]);
            
            res=Math.max(Math.max(sell[i][0],sell[i][1]),res);
        }
        
        return res;
    }
}