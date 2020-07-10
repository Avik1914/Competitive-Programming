/*
Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays in place, i. e., we need to consider all n + m elements in sorted order, then we need to put first n elements of these sorted in first array and remaining m elements in second array.

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

Input: arr1[] = {10};
       arr2[] = {2, 3};
Output: arr1[] = {2}
        arr2[] = {3, 10}  

Input: arr1[] = {1, 5, 9, 10, 15, 20};
       arr2[] = {2, 3, 8, 13};
Output: arr1[] = {1, 2, 3, 5, 8, 9}
        arr2[] = {10, 13, 15, 20} 
Input:
First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.

Output:
For each test case, print (X + Y) space separated integer representing the merged array.

Your Task:
This is a function problem. You only need to complete the function merge() that takes n and m as parameters.

Constraints:
1 <= T <= 100
1 <= X, Y <= 5*104
0 <= arr1i, arr2i <= 109

Example:
Input:
2
4 5
1 3 5 7
0 2 6 8 9
2 3
10 12
5 18 20
Output:
0 1 2 3 5 6 7 8 9
5 10 12 18 20

Explanation:
Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.
Testcase 2: After merging two sorted arrays , we have 5 10 12 18 20.
*/

//Sorting Approach
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		
		while(tc-->0){
		    int a1=sc.nextInt();
		    int a2=sc.nextInt();
		    int arr1[]=new int[a1];
		    int arr2[]=new int[a2];
		    
		    int ptr1=0,ptr2=0,temp=0;
		    
		    for(int i=0;i<a1;i++)
		        arr1[i]=sc.nextInt();
		    for(int i=0;i<a2;i++)
		        arr2[i]=sc.nextInt();
		     
		    for(int i=0;i<Math.min(a1, a2);i++){
		    	if(arr1[ptr1]<arr2[ptr2])
		    		ptr1++;
		    	else
		    		ptr2++;
		    }
		    
		    if (ptr2 > 0) {
			    ptr1=a1-1;
			for (int i = 0; i < ptr2; i++) {
				temp = arr2[i];
				arr2[i] = arr1[ptr1];
				arr1[ptr1] = temp;
				ptr1--;
			}

			    Arrays.sort(arr1);
			    Arrays.sort(arr2);
		    }
		    
		    for(int i=0;i<a1;i++)
		        System.out.print(arr1[i]+" ");
		    for(int i=0;i<a2-1;i++)
		         System.out.print(arr2[i]+" ");
		    System.out.print(arr2[a2-1]);
		    System.out.println();
		    
		}
	}
}

/*Insertion Sort shifting Approach*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    int a1=sc.nextInt();
		    int a2=sc.nextInt();
		    int arr1[]=new int[a1];
		    int arr2[]=new int[a2];
		    
		    for(int i=0;i<a1;i++)
		        arr1[i]=sc.nextInt();
		    for(int i=0;i<a2;i++)
		        arr2[i]=sc.nextInt();
            
            for(int i=a2-1;i>=0;i--){
                int last=arr1[a1-1];
                int itr=a1-2;
                while(itr>=0 && arr2[i]<arr1[itr]){
                    arr1[itr+1]=arr1[itr];
                    itr--;
                }
                if(last>arr2[i]){
                    arr1[itr+1]=arr2[i];
                    arr2[i]=last;
                }
            }
             for(int i=0;i<a1;i++)
		        System.out.print(arr1[i]+" ");
		    for(int i=0;i<a2-1;i++)
		         System.out.print(arr2[i]+" ");
		    System.out.print(arr2[a2-1]);
		    System.out.println();
        }
    }
}
