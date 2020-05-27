/*
Given a number n, count minimum steps to minimise it to 1 according to the following criteria:

If n is divisible by 2 then we may reduce n to n/2.
If n is divisible by 3 then you may reduce n to n/3.
Decrement n by 1.
 

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N denoting the number n.

 

Output:

Output the minimum steps to minimise the number in a new line for each test case.


Constraints:

1<= T <=1000

1<= N <=10000


Example:

Input:

2

10

6

Output:

3

2
*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    int n=sc.nextInt();
		    int[] dp=new int[n+1];
		    for(int i=2;i<=n;i++){
		        dp[i]=1+dp[i-1];
		        if(i%2==0)
		            dp[i]=Math.min(dp[i],1+dp[i/2]);
		        if(i%3==0)
		            dp[i]=Math.min(dp[i],1+dp[i/3]);
		    }
		    System.out.println(dp[n]);
		}
	}
	//Memoization
	public static int dfs(int val,int[] dp){
	    if(val==1)
	        return 0;
	    if(dp[val]!=0)
	        return dp[val];
	    int res=Integer.MAX_VALUE;
	    if(val%2==0)
	        res=Math.min(res,1+dfs(val/2,dp));
	    if(val%3==0)
	        res=Math.min(res,1+dfs(val/3,dp));
	    res=Math.min(res,1+dfs(val-1,dp));
	    dp[val]=res;
	    return res;
	}
}
