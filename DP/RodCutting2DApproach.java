
/*
Cutting a Rod | DP-13
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20
And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
*/

public class RodCutting {

	public static void main(String args[]) 
    { 
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
        int size = arr.length; 
        int[][] dp=new int[9][9];
        int res=0;
        for(int i=1;i<=8;i++){
        	for(int j=1;j<=8;j++){
        		if(i==1)
        			dp[i][j]=arr[0]*j;
        		else if(j<i)
        			dp[i][j]=dp[i-1][j];
        		else
        			dp[i][j]=Math.max(arr[i-1]+dp[i][j-i],dp[i-1][j]);
        		
        		if(j==8)
        			res=Math.max(res,dp[i][j]);
        	}
        }
        System.out.println(res);
  
    } 

}
