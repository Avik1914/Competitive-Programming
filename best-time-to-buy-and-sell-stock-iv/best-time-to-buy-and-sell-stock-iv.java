class Solution {
    public int maxProfit(int k, int[] prices) {
      
        int len=prices.length;
        if(len==0 || k==0)
            return 0;
        int[][] buy=new int[len][k+1];
        int[][] sell=new int[len][k+1];
        
        buy[0][1]=-prices[0];
        for(int i=2;i<=k;i++)
            buy[0][i]=Integer.MIN_VALUE;
        int res=0;
        
        for(int j=1;j<=k;j++){
            for(int i=1;i<len;i++){
                buy[i][j]=Math.max(buy[i-1][j],sell[i-1][j-1]-prices[i]);
                sell[i][j]=Math.max(sell[i-1][j],buy[i-1][j]+prices[i]);
                res=Math.max(res,sell[i][j]);
            }
        }
        
        
        return res;
    }
}