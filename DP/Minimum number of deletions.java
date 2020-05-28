/*
Given a string 'str' of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.

Note: The order of characters should be maintained.

 

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N denoting the length of string str.

The second line of each test case contains the string str.


Output:

Print the minimum number of characters to be deleted to make the string a palindrome for each testcase in a new line.


Constraints:

1<= T <=100

1<= N <= 1000


Example:

Input:

1

7

aebcbda

Output:

2
*/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    int n=sc.nextInt();
		    char[] arr=sc.next().toCharArray();
		    int[][] dp=new int[n+1][n+1];
		    
		    /*for(int i=0;i<=n;i++)
		        Arrays.fill(dp[i],-1);*/
		    
		    for(int i=2;i<=n;i++){
		        int c=i;
		        int r=1;
		        while(c<=n){
		            if(arr[r-1]==arr[c-1])
		                dp[r][c]=dp[r+1][c-1];
		            else
		                 dp[r][c]=1+Math.min(dp[r][c-1],dp[r+1][c]);
		               r++;
		               c++;
		        }
		    }
		    
		    
		    //System.out.println(dfs(arr,dp,0,n-1));
		    System.out.println(dp[1][n]);
		}
	}
	
	public static int dfs(char[] arr,int[][] dp,int f,int e){
	    if(f>=e)
	        return 0;
	    if(dp[f][e]!=-1)
	        return dp[f][e];
	    if(arr[f]==arr[e])
	        dp[f][e]=dfs(arr,dp,f+1,e-1);
	    else
	        dp[f][e]=1+Math.min(dfs(arr,dp,f+1,e),dfs(arr,dp,f,e-1));
	    
	    return dp[f][e];
	}
}
