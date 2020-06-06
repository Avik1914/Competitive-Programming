/*
Counting numbers of n digits that are monotone
Call decimal number a monotone if:

   D[\, i]\, \leqslant D[\, i+1]\, 0 \leqslant i \leqslant |D| .

Write a program which takes positive number n on input and returns number of decimal numbers of length n that are monotone. Numbers can’t start with 0.

Examples :




Input : 1
Output : 9
Numbers are 1, 2, 3, ... 9

Input : 2
Output : 45
Numbers are 11, 12, 13, .... 22, 23
...29, 33, 34, ... 39.
Count is 9 + 8 + 7 ... + 1 = 45
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] dp=new int[n+1][11];
        int res=0;
        for(int i=1;i<=n;i++){
            for(int j=9;j>=1;j--){
                if(i==1)
                    dp[i][j]=10-j;
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j+1];
                }
            }
        }
        System.out.println(dfs(n,1));
        System.out.println(dp[n][1]);
    }
    
    public static int dfs(int n,int start){
        if(n==0)
            return 1;
        int res=0;
        
        for(int i=start;i<10;i++){
            res+=dfs(n-1,i);    
        }
        return res;
    }
}
