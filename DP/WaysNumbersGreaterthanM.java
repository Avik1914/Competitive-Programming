/*
Given two natural number n and m. The task is to find the number of ways in which the numbers that are greater than or equal to m can be added to get the sum n.

Examples:

Input : n = 3, m = 1
Output : 3
Following are three different ways
to get sum n such that each term is
greater than or equal to m
1 + 1 + 1, 1 + 2, 3 

Input : n = 2, m = 1
Output : 2
Two ways are 1 + 1 and 2
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] dp=new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            for(int j=i;j>0;j--){
                if(i==j)
                    dp[i][j]=1;
                else 
                    dp[i][j]=dp[i][j+1]+dp[i-j][j];
            }
        }
        
        //System.out.println(dfs(n,m));
        System.out.println(dp[n][m]);
    }
    
    public static int dfs(int n,int m){
        if(n==m)
            return 1;
        if(n<0 || m>n)
            return 0;
        return dfs(n-m,m)+dfs(n,m+1);
    }
}
