class Solution {
    Integer[][] dp;
    public int minSwap(int[] A, int[] B) {
        dp=new Integer[A.length][2];
        int a=dfs(A,B,1,0);
        int b=dfs(A,B,1,1);
        
        if(a==-1)
            return 1+b;
        else if(b==-1)
            return a;
        return Math.min(a,1+b);
    }
    
    public int dfs(int[] A,int[] B,int start,int swap){
        if(start>=A.length)
            return 0;
        if(dp[start][swap]!=null)
            return dp[start][swap];
        if(swap==0){
            int a=-1,b=-1;
            if(A[start]>A[start-1] && B[start]>B[start-1])
                    a=dfs(A,B,start+1,0);
            if(A[start]>B[start-1] && B[start]>A[start-1])
                    b=dfs(A,B,start+1,1);
            if(a==-1)
                dp[start][swap]=b==-1?-1:1+b;
            else if(b==-1)
                dp[start][swap]=a;
            else
                dp[start][swap]=Math.min(a,1+b);
            return dp[start][swap];
        }
        int a=-1,b=-1;
        if(A[start]>B[start-1] && B[start]>A[start-1])
                a=dfs(A,B,start+1,0);
        if(A[start]>A[start-1] && B[start]>B[start-1])
                b=dfs(A,B,start+1,1);
        if(a==-1)
            dp[start][swap]=b==-1?-1:1+b;
        else if(b==-1)
            dp[start][swap]=a;
        else
            dp[start][swap]=Math.min(a,1+b);
        
        return dp[start][swap];
    }
}