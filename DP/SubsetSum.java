/*
Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elements in both subsets is same or not.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Each test case constitutes of two lines. First line contains 'N', representing the number of elements in the set and the second line contains the elements of the set.

Output:
Print YES if the given set can be partioned into two subsets such that the sum of elements in both subsets is equal, else print NO.

Constraints:
1 <= T <= 100
1 <= N <= 100
0 <= arr[i] <= 1000

Example:
Input:
2
4
1 5 11 5
3
1 3 5 

Output:
YES
NO

Explanation:
Testcase 1: There exists two subsets such that {1, 5, 5} and {11}.
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
		    int arr[]=new int[n];
		    int sum=0;
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		        sum+=arr[i];
		    }
		    if((sum & 1)==1)
		        System.out.println("NO");
		    else{
		        sum=sum/2;
		        boolean[][] dp=new boolean[n+1][sum+1]   ;
		        
		        for(int i=0;i<=n;i++)
		            dp[i][0]=true;
		        for(int i=1;i<=sum;i++)
		            dp[0][i]=false;
		            
		        for(int i=1;i<=n;i++){
		            for(int j=1;j<=sum;j++){
		                if(arr[i-1]<=j)
		                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
		                else
		                dp[i][j]=dp[i-1][j];
		            }
		        }
		        if(dp[n][sum])
		            System.out.println("YES");
		        else
		            System.out.println("NO");
		    }
		}
	}
}
