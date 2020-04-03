/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of four lines.
The first line consists of N the number of items.
The second line consists of W, the maximum capacity of the knapsack.
In the next line are N space separated positive integers denoting the values of the N items,
and in the fourth line are N space separated positive integers denoting the weights of the corresponding items.

Output:
For each testcase, in a new line, print the maximum possible value you can get with the given conditions that you can obtain for each test case in a new line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ v[i] ≤ 1000

Example:
Input:
2
3
4
1 2 3
4 5 1
2
3
1 2 3
4 5 6
Output:
3
1
*/

/*Recursive Approach*/
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
		    int w=sc.nextInt();
		    int[] weights=new int[n];
		    int[] prices=new int[n];
		    
		    for(int i=0;i<n;i++)
		      prices[i]=sc.nextInt();
		      
		    for(int i=0;i<n;i++)
		      weights[i]=sc.nextInt();
		      
		   System.out.println(dfs(weights,prices,0,w));
		}
	}
	
	public static int dfs(int[] weights,int[] prices,int start,int W){
	    if(start>=weights.length)
	        return 0;
	    if(W<weights[start])
	        return dfs(weights,prices,start+1,W);
	   return Math.max(prices[start]+dfs(weights,prices,start+1,W-weights[start]),
	                        dfs(weights,prices,start+1,W));
	}
}

/* Top Down Approach */

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
		    int w=sc.nextInt();
		    int[] weights=new int[n];
		    int[] prices=new int[n];
		    
		    for(int i=0;i<n;i++)
		      prices[i]=sc.nextInt();
		      
		    for(int i=0;i<n;i++)
		      weights[i]=sc.nextInt();
		   int[][] dp=new int[n+1][w+1];
		   
		   for(int i=1;i<=n;i++){
		       for(int j=1;j<=w;j++){
		           if(weights[i-1]>j)
		            dp[i][j]=dp[i-1][j];
		           else
		            dp[i][j]=Math.max(prices[i-1]+dp[i-1][j-weights[i-1]],dp[i-1][j]);
		       }
		   }
		   System.out.println(dp[n][w]);
		}
	}
}
