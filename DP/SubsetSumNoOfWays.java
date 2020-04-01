/*
Given an array of integers and a sum, the task is to count all subsets of given array with sum equal to given sum.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an nteger n denoting the size of the array. The next line contains n space separated integers forming the array. The last line contains the sum.

Output:
Count all the subsets of given array with sum equal to given sum.

Constraints:
1<=T<=10^5
1<=n<=10^5
1<=a[i]<=10^5
1<=sum<=10^5

Example:
Input:
2
6
2 3 5 6 8 10
10
5
1 2 3 4 5
10

Output:
3
3
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
		    int sum=sc.nextInt();
		    int[][] dp=new int[n+1][sum+1];
		    
		    int count=0;
		    for(int i=0;i<=n;i++){
		        for(int j=0;j<=sum;j++){
		            if(j==0)
		                dp[i][j]=1;
		            else if(i!=0){
		                if(arr[i-1]>j)
		                    dp[i][j]=dp[i-1][j];
		                else
		                    dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
		               if(j==sum && dp[i][j]>0 && j-arr[i-1]>=0)
		                count+=dp[i-1][j-arr[i-1]];
		            }
		        }
		    
		    }
		    System.out.println(count);
		}
	}
}
