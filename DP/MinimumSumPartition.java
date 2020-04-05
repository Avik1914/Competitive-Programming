/*
Given an array, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line contains an integer 'N' denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.


Output:
In each seperate line print minimum absolute difference.


Constraints:
1<=T<=30
1<=N<=50
1<=A[I]<=50


Example:
Input:
2
4
1 6 5 11
4
36 7 46 40

Output : 
1
23

Explaination :
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11},       sum of Subset2 = 11
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    int n=sc.nextInt();
		    int[] nums=new int[n];
		    int sum=0;
		    
		    for(int i=0;i<n;i++){
		        nums[i]=sc.nextInt();
		        sum+=nums[i];
		    }
		    boolean[][] dp=new boolean[n+1][sum+1];
		    int res=sum;
		    for(int i=0;i<=n;i++){
                for(int j=0;j<=sum;j++){
                    if(j==0)
                        dp[i][j]=true;
                    else if(i==0)
                        dp[i][j]=false;
                    else if(nums[i-1]>j)
                        dp[i][j]=dp[i-1][j];
                    else
                        dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    if(dp[i][j])
                        res=Math.min(res,Math.abs(2*j-sum));
                        
                }
            }
		    System.out.println(res);
		}
	}
}
