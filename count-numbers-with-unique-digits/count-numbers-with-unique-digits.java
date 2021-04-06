class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 10;
        int[] dp=new int[n+1];
        dp[1]=9;
        int mul=9;
        int res=10;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]*mul--;
            res+=dp[i];
        }
        return res;
    }
}