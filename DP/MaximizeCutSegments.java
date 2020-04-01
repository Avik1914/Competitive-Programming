/*
Given an integer N denoting the Length of a line segment. you need to cut the line segment in such a way that the cut length of a line segment each time is integer either x , y or z. and after performing all cutting operation the total number of cutted segments must be maximum. 


Input
First line of input contains of an integer 'T' denoting number of test cases. First line of each testcase contains N . Second line of each testcase contains 3 space separated integers x , y and z.

Output
For each test case print in a new line an integer corresponding to the answer .


Constraints
1<=t<=70
1<=N,x,y,z<=4000
 

Example

Input

2
4
2 1 1
5
5 3 2


Output
4
2

In first test case, total length is 4, and cut lengths are 2, 1 and 1.  We can make maximum 4 segments each of length 1. In secon test case, we can make two segments of lengths 3 and 2.
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
		    int[] arr=new int[3];
		    
		    for(int i=0;i<3;i++)
		        arr[i]=sc.nextInt();
		    
		    int[][] dp=new int[4][n+1];
		    int res=0;
		    for(int i=1;i<=3;i++){
		        for(int j=1;j<=n;j++){
		            
		            if(arr[i-1]>j)
		                dp[i][j]=dp[i-1][j];
		            else{
		                if(dp[i][j-arr[i-1]]>0 || j-arr[i-1]==0)
		                    dp[i][j]=Math.max(dp[i-1][j],1+dp[i][j-arr[i-1]]);
		                else
		                    dp[i][j]=dp[i-1][j];
		            }
		            if(j==n)
		                res=Math.max(res,dp[i][j]);
		        }
		    }
		    System.out.println(res);
		}
	}
}
