/*
Given an array of integers A. A subsequence of A is called Bitonic if it is first increasing then decreasing.

Input:
The first line contains an integer T denoting the no of test cases. Each test case consist of two lines. The first line contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A[].

Output:
For each test case in a new line print the max sum bitonic subsequence.

Constraints:
1<=T<=100
1<=N<=50
1<=A[]<=100

Example:
Input:
2
6
80 60 30 40 20 10
9
1 15 51 45 33 100 12 18 9

Output:
210
194

Explanation:
Testcase2:
Input : A[] = {1, 15, 51, 45, 33, 100, 12, 18, 9}
Output : 194
 Bi-tonic Sub-sequence are :
{1, 51, 9}
{1, 50, 100, 18, 9}
{1, 15, 51, 100, 18, 9}
{1, 15, 45, 100, 12, 9}
{1, 15, 45, 100, 18, 9} .. so on           
Maximum sum Bi-tonic sub-sequence is 1 + 15 + 51 + 100 + 18 + 9 = 194  
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
		    int[] arr=new int[n];
		    
		    for(int i=0;i<n;i++)
		        arr[i]=sc.nextInt();
		    int[] dp=new int[n];
		    int res=0;
		    for(int i=0;i<n;i++){
		        dp[i]=arr[i];
		        for(int j=0;j<i;j++){
		            if(arr[i]>arr[j]){
		                dp[i]=Math.max(dp[j]+arr[i],dp[i]);
		            }
		        }
		    }
		    int[] lowDp=new int[n];
		   
		    for(int i=n-1;i>=0;i--){
		        lowDp[i]=arr[i];
		        for(int j=i+1;j<n;j++){
		            if(arr[i]>arr[j])
		                lowDp[i]=Math.max(lowDp[j]+arr[i],lowDp[i]);
		        }
		        if(lowDp[i]!=0 && dp[i]!=0)
		            res=Math.max(lowDp[i]+dp[i]-arr[i],res);
		    }
		    
		    System.out.println(res);
		}
	}
}
