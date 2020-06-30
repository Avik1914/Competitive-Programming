/*
Given an integer n > 0, which denotes the number of digits, the task to find total number of n-digit positive integers which are non-decreasing in nature.
A non-decreasing integer is a one in which all the digits from left to right are in non-decreasing form. ex: 1234, 1135, ..etc.
Note :Leading zeros also count in non-decreasing integers such as 0000, 0001, 0023, etc are also non-decreasing integers of 4-digits.

Examples :

Input : n = 1
Output : 10
Numbers are 0, 1, 2, ...9.

Input : n = 2
Output : 55

Input : n = 4
Output : 715
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] dp=new int[n+1][10];
        Arrays.fill(dp[0],1);
        int res=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<10;j++){
                    if(j==0)
                        dp[i][j]+=dp[i-1][j];
                    else
                        dp[i][j]+=dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(dp[n][9]);
    }
    
    
    public static int dfs(int n,int start){
        if(n==0)
            return 1;
        int res=0;
        for(int i=start;i>=0;i--){
            res+=dfs(n-1,i);
        }
        return res;
    }
}
