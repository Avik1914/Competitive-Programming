/*
Given a gold mine (M) of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. Your task is to find out maximum amount of gold which he can collect.

Examples:

Input : M[][] = {{1, 3, 3},
                 {2, 1, 4},
                 {0, 6, 4}};
Output : 12 
{(1,0)->(2,1)->(2,2)}

Input: M[][] = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};
Output : 16
(2,0) -> (1,1) -> (1,2) -> (0,3) OR
(2,0) -> (3,1) -> (2,2) -> (2,3)


Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer n and m denoting the size of the matrix. Then in the next line are n*m space separated values of the matrix.

Output:
For each test case in a new line print an integer denoting the max gold the miner could collect.

Constraints:
1<=T<=100
1<=n,m<=20
1<=M[][]<=100

Example:
Input:
2
3 3 
1 3 3 2 1 4 0 6 4
2 2
1 2 3 4
Output:
12
7
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
		    int m=sc.nextInt();
		    
		    int arr[][]=new int[n+1][m+1];
		    int max=0;
		    for(int i=0;i<n;i++){
		        for(int j=0;j<m;j++){
		            arr[i][j]=sc.nextInt();
		            max=Math.max(arr[i][j],max);
		        }
		    }
		    
		    for(int i=1;i<m;i++){
		        for(int j=0;j<n;j++){
		            int val=0;
		            if(i-1>=0 && j-1>=0)
		                val=Math.max(val,arr[j-1][i-1]);
		            if(i-1>=0)
		                val=Math.max(val,arr[j][i-1]);
		            if(j+1<n && i-1>=0)    
		                val=Math.max(val,arr[j+1][i-1]);
		            arr[j][i]+=val;
		            if(i==m-1)
		                max=Math.max(arr[j][i],max);
		        }
		    }
		    System.out.println(max);
		}
	}
}
