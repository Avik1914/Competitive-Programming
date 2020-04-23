/*
Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.

Examples:
Input: str = "aabb"
Output: "ab"

Input: str = "aab"
Output: "a"
The two subsequence are 'a'(first) and 'a' 
(second). Note that 'b' cannot be considered 
as part of subsequence as it would be at same
index in both.
*/

/*Memoized Approach */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		     int len=sc.nextInt();
		     String str=sc.next();
		     int[][] dp=new int[len][len];
		     for(int i=0;i<len;i++)
		        Arrays.fill(dp[i],-1);
		     System.out.println(getString(str.toCharArray(),len-1,len-1,dp));
		}
	}
	
	public static int getString(char[] str,int i,int j,int[][] dp){
	    if(i<0 || j<0)
	        return 0;
	    if(dp[i][j]!=-1)
	        return dp[i][j];
	    if(i!=j && str[i]==str[j])
	        dp[i][j]=1+getString(str,i-1,j-1,dp);
	    else
	        dp[i][j]=Math.max(getString(str,i-1,j,dp),getString(str,i,j-1,dp));
	    return dp[i][j];
	}
}

/*Iterative Approach*/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		     int len=sc.nextInt();
		     String str=sc.next();
		     int[][] dp=new int[2][len+1];
		     char[] arr=str.toCharArray();
		     for(int i=1;i<=len;i++){
		        for(int j=1;j<=len;j++){
		            if(i!=j && arr[i-1]==arr[j-1])
		                dp[i%2][j]=1+dp[(i-1)%2][j-1];
		            else
		                dp[i%2][j]=Math.max(dp[(i-1)%2][j],dp[i%2][j-1]);
		        }
		     }
		     System.out.println(dp[len%2][len]);
		}
	}
}
