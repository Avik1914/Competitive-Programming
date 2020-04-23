/*
Sequences of given length where every element is more than or equal to twice of previous
Given two integers m & n, find the number of possible sequences of length n such that each of the next element is greater than or equal to twice of the previous element but less than or equal to m.

Examples :

Input : m = 10, n = 4
Output : 4
There should be n elements and value of last
element should be at-most m.
The sequences are {1, 2, 4, 8}, {1, 2, 4, 9},
                 {1, 2, 4, 10}, {1, 2, 5, 10}

Input : m = 5, n = 2
Output : 6
The sequences are {1, 2}, {1, 3}, {1, 4},
                  {1, 5}, {2, 4}, {2, 5}
*/

/*Recursive Solution*/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    int m=sc.nextInt();
		    int n=sc.nextInt();
		    System.out.println(dfs(m,n,1));
		}
	}
	
	public static int dfs(int m,int n,int prev){
	    
	    if(n==0)
	        return 1;
	    if(prev>m)
	        return 0;
	    int sum=0;
	    for(int i=prev;i<=m;i++){
	       sum+=dfs(m,n-1,i<<1);
	    }
	    return sum;
	}
}

/* Memoized Solution */
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    int m=sc.nextInt();
		    int n=sc.nextInt();
		    int[][] dp=new int[m<<1][n+1];
		    for(int i=0;i<(m<<1);i++)
		        Arrays.fill(dp[i],-1);
		    System.out.println(dfs(m,n,1,dp));
		}
	}
	
	public static int dfs(int m,int n,int prev,int[][] dp){
	    
	    if(n==0)
	        return 1;
	    if(prev>m)
	        return 0;
	    if(dp[prev][n]!=-1)
	        return dp[prev][n];
	    int sum=0;
	    for(int i=prev;i<=m;i++){
	       sum+=dfs(m,n-1,i<<1,dp);
	    }
	    dp[prev][n]=sum;
	    return sum;
	}
}
